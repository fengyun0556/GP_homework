package com.gupaoedu.spring.framework.webmvc.servlet;

import com.gupaoedu.spring.framework.annotation.GPController;
import com.gupaoedu.spring.framework.annotation.GPRequestMapping;
import com.gupaoedu.spring.framework.context.GPApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GPDispatcherServlet extends HttpServlet {

    private static final String LOCATION = "contextConfigLocation";

    private GPApplicationContext context;

    private List<GPHandlerMapping> handlerMappings = new ArrayList<>();

    private Map<GPHandlerMapping, GPHandlerAdapter> handlerAdapter = new HashMap<>();

    private List<GPViewResolver> viewResolvers = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        context = new GPApplicationContext(config.getInitParameter(LOCATION));
        this.initStrategies(context);
    }

    protected void initStrategies(GPApplicationContext context) {
        initMultipartResolver(context);
        initLocaleResolver(context);
        initThemeResolver(context);

        initHandlerMappings(context);
        initHandlerAdapters(context);

        initHandlerExceptionResolvers(context);
        initRequestToViewNameTranslator(context);
        initViewResolvers(context);
        initFlashMapManager(context);
    }

    private void initFlashMapManager(GPApplicationContext context) {}
    private void initRequestToViewNameTranslator(GPApplicationContext context) {}
    private void initHandlerExceptionResolvers(GPApplicationContext context) {}
    private void initThemeResolver(GPApplicationContext context) {}
    private void initLocaleResolver(GPApplicationContext context) {}
    private void initMultipartResolver(GPApplicationContext context) {}

    private void initHandlerMappings(GPApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object controller = context.getBean(beanName);
            Class<?> clazz = controller.getClass();
            if (!clazz.isAnnotationPresent(GPController.class)) continue;
            String baseURL = "";
            if (clazz.isAnnotationPresent(GPRequestMapping.class)) {
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseURL = requestMapping.value();
            }

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(GPRequestMapping.class)) continue;
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                String regex = ("/" + baseURL + requestMapping.value().replaceAll("\\*", "."))
                        .replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(regex);
                this.handlerMappings.add(new GPHandlerMapping(controller, method, pattern));
                System.out.println("Mapping:" + regex + "," + method);
            }
        }
    }

    private void initHandlerAdapters(GPApplicationContext context) {
        for (GPHandlerMapping handlerMapping : this.handlerMappings) {
            this.handlerAdapter.put(handlerMapping, new GPHandlerAdapter());
        }
    }

    private void initViewResolvers(GPApplicationContext context) {
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        File templateRootDir = new File(templateRootPath);
        for (File file : templateRootDir.listFiles()) {
            this.viewResolvers.add(new GPViewResolver(file));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.doDispatch(req, resp);
        } catch (Exception e){
            resp.getWriter().write("<font size='25' color='blue'>500 Exception</font><br/>Details:<br/>"
                    + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]","").replaceAll("\\s","\r\n")
                    + "<font color='green'><i>Copyright@GupaoEDU</i></font>");
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        GPHandlerMapping handler = getHandler(req);
        if (handler == null){
            processDispatchResult(req, resp, new GPModelAndView("404"));
            return;
        }

        GPHandlerAdapter ha = this.getHandlerAdapter(handler);
        GPModelAndView mv = ha.handle(req, resp, handler);

        processDispatchResult(req, resp, mv);//真正的输出
    }

    private GPHandlerAdapter getHandlerAdapter(GPHandlerMapping handler) {
        if (this.handlerAdapter.isEmpty()) return null;
        GPHandlerAdapter ha = this.handlerAdapter.get(handler);
        if (ha.supports(handler)) return ha;
        return null;
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, GPModelAndView modelAndView) throws Exception {
        if (null == modelAndView) return;
        if (this.viewResolvers.isEmpty()) return;
        if (this.viewResolvers != null){
            for (GPViewResolver viewResolver : this.viewResolvers) {
                GPView view = viewResolver.resolveViewName(modelAndView.getViewName(), null);
                if (view != null){
                    view.render(modelAndView.getModel(), req, resp);
                    return;
                }
            }
        }
    }

    private GPHandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMappings.isEmpty()) return null;
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        for (GPHandlerMapping handlerMapping : this.handlerMappings) {
            Matcher matcher = handlerMapping.getPattern().matcher(url);
            if (matcher.matches()) continue;
            return handlerMapping;
        }
        return null;
    }

}
