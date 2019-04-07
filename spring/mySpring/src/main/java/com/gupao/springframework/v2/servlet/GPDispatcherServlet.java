package com.gupao.springframework.v2.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gupao.springframework.annotation.*;

public class GPDispatcherServlet extends HttpServlet {

    //保存配置文件中的内容
    private Properties contextConfig = new Properties();

    //保存扫描到的所有类名
    private List<String> classNames = new ArrayList<>();

    //IOC容器
    private Map<String, Object> ioc = new HashMap<>();

    private Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.doDispatcher(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 : Exception detail " + Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");

        if (!handlerMapping.containsKey(url)){
            resp.getWriter().write("404 Not Found!!!");
            return;
        }

        Method method = this.handlerMapping.get(url);
        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());

        Map<String, String[]> params = req.getParameterMap();

        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] paramValues = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class){
                paramValues[i] = req;
                continue;
            } else if (parameterType == HttpServletResponse.class){
                paramValues[i] = resp;
                continue;
            } else if (parameterType == String.class) {
                Annotation[][] pa = method.getParameterAnnotations();
                for (int j = 0; j < pa.length; j++) {
                    for (Annotation a : pa[j]) {
                        if (a instanceof GPRequestParam){
                            String paramName = ((GPRequestParam) a).value();

                            if (params.containsKey(paramName)) {
                                for (Map.Entry<String, String[]> param : params.entrySet()) {
                                    String value = Arrays.toString(param.getValue())
                                            .replaceAll("\\[|\\]", "")
                                            .replaceAll("\\s", ",");
                                    paramValues[i] = value;
                                }
                            }
                        }
                    }
                }
            }
        }
        method.invoke(ioc.get(beanName), paramValues);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件
        this.doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //2、扫描相关的类
        this.doScanner(String.valueOf(contextConfig.get("scanPackage")));

        //3、初始化扫描到的类，并将它们放入到IOC容器中
        doInstance();

        //4、完成依赖注入
        doAutowired();

        //5、初始化HandlerMapping
        initHandlerMapping();

        System.out.println("GP Spring framework is init");
    }

    //初始化URL和method的一对一对应关系
    private void initHandlerMapping() {
        if (ioc.isEmpty()) return;

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(GPController.class)) continue;

            String baseUrl = "";
            if (clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(GPRequestMapping.class)) continue;

                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                String url = ("/" + baseUrl + "/" + requestMapping.value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);
            }
        }
    }

    private void doAutowired() {
        if (ioc.isEmpty()) return;
        try {
            for (Map.Entry<String, Object> entry : ioc.entrySet()) {
                Field[] fields = entry.getValue().getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (!field.isAnnotationPresent(GPAutowired.class)) continue;

                    GPAutowired autowired = field.getAnnotation(GPAutowired.class);

                    field.setAccessible(true);//强制赋值，在反射中，叫做暴力访问

                    String beanName = autowired.value();
                    if ("".equals(beanName)){
                        beanName = field.getType().getName();
                    }

                    field.set(entry.getValue(), ioc.get(beanName));
                }
            }
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

    private void doInstance() {
        try {
            //初始化，为DI做准备
            if (classNames.isEmpty()) return;

            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(GPController.class)) {
                    Object instance = clazz.newInstance();
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName, instance);
                } else if (clazz.isAnnotationPresent(GPService.class)) {
                    Object instance = clazz.newInstance();
                    GPService gpService = clazz.getAnnotation(GPService.class);
                    String value = gpService.value();
                    String beanName;
                    if (!"".equals(value)){
                        beanName = value.trim();
                    } else {
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }

                    for (Class<?> i : clazz.getInterfaces()) {
                        if (ioc.containsKey(i.getName())) throw new Exception("already contain bean : " + i.getName());
                        ioc.put(i.getName(), instance);
                    }
                    ioc.put(beanName, instance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toLowerFirstCase(String name) {
        char[] chars = name.toCharArray();
        chars[0] += 32;
        return new String(chars);
    }

    private void doScanner(String scanPackage) {
        //转换为文件路径
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                this.doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) continue;
                String className = scanPackage + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {
        //将配置文件读取到内存中
        try (InputStream io = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation)) {
            contextConfig.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
