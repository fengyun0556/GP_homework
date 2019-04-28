package com.gupaoedu.spring.framework.aop.support;

import com.gupaoedu.spring.framework.aop.GPAopConfig;
import com.gupaoedu.spring.framework.aop.aspect.GPAfterThrowingAdvice;
import com.gupaoedu.spring.framework.aop.aspect.GPMethodBeforeAdvice;
import com.gupaoedu.spring.framework.aop.aspect.GpAfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GPAdvisedSupport {
    private Class targetClass;
    private Object target;
    private Pattern pointCutClassPattern;

    private transient Map<Method, List<Object>> methodCache;

    private GPAopConfig config;

    public GPAdvisedSupport(GPAopConfig config) {
        this.config = config;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method, Class<?> targetClass) throws NoSuchMethodException {
        List<Object> cached = methodCache.get(method);
        if (cached == null){
            Method m = targetClass.getMethod(method.getName(), method.getParameterTypes());
            cached = methodCache.get(m);
            this.methodCache.put(m, cached);
        }
        return cached;
    }

    public boolean pointCutMatch(){
        return pointCutClassPattern.matcher(this.targetClass.toString()).matches();
    }

    private void parse(){
        String pointCut = config.getPointCut()
                .replaceAll("\\.","\\\\.")
                .replaceAll("\\\\.\\*",".*")
                .replaceAll("\\(","\\\\(")
                .replaceAll("\\)","\\\\)");
        String pointCutForClass = pointCut.substring(0, pointCut.lastIndexOf("\\(") - 4);
        pointCutClassPattern = Pattern.compile("class " +
                pointCutForClass.substring(pointCutForClass.lastIndexOf(" ") + 1));
        methodCache = new HashMap<>();
        Pattern pattern = Pattern.compile(pointCut);
        try {
            Class aspectClass = Class.forName(config.getAspectClass());
            Map<String, Method> aspectMethods = new HashMap<>();
            for (Method method : aspectClass.getMethods()) {
                aspectMethods.put(method.getName(), method);
            }

            for (Method method : targetClass.getMethods()) {
                String methodString = method.toString();
                if (methodString.contains("throws")){
                    methodString = methodString.substring(0, methodString.lastIndexOf("throws")).trim();
                    Matcher matcher = pattern.matcher(methodString);
                    if (matcher.matches()){
                        //能满足切面规则的类
                        List<Object> advices = new LinkedList<>();
                        //前置通知
                        if (!(null == config.getAspectBefore() || "".equals(config.getAspectBefore().trim()))){
                            advices.add(new GPMethodBeforeAdvice
                                    (aspectMethods.get(config.getAspectBefore()), aspectClass.newInstance()));
                        }
                        //后置通知
                        if (!(null == config.getAspectAfter() || "".equals(config.getAspectAfter().trim()))){
                            advices.add(new GpAfterReturningAdvice
                                    (aspectMethods.get(config.getAspectAfter()), aspectClass.newInstance()));
                        }
                        //异常通知
                        if (!(null == config.getAspectAfterThrow() || "".equals(config.getAspectAfterThrow().trim()))){
                            advices.add(new GPAfterThrowingAdvice
                                    (aspectMethods.get(config.getAspectAfterThrow()), aspectClass.newInstance()));
                        }
                        methodCache.put(method, advices);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
