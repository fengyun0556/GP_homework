package com.gupaoedu.spring.framework.context;

import com.gupaoedu.spring.framework.annotation.GPAutowired;
import com.gupaoedu.spring.framework.annotation.GPController;
import com.gupaoedu.spring.framework.annotation.GPService;
import com.gupaoedu.spring.framework.beans.GPBeanDefinition;
import com.gupaoedu.spring.framework.beans.GPBeanWrapper;
import com.gupaoedu.spring.framework.beans.support.GPBeanDefinitionReader;
import com.gupaoedu.spring.framework.beans.support.GPDefaultListableBeanFactory;
import com.gupaoedu.spring.framework.core.GPBeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {

    private String[] configLocations;
    private GPBeanDefinitionReader reader;

    //单例的IOC容器缓存
    private Map<String,Object> factoryBeanObjectCache = new ConcurrentHashMap<>();
    //通用的IOC容器
    private Map<String,GPBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();

    public GPApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refresh() throws Exception {
        //1、定位，定位配置文件
        reader = new GPBeanDefinitionReader(this.configLocations);

        //2、加载配置文件，扫描相关的类，把他们封装成BeanDefinition
        List<GPBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();

        //3、注册，把配置信息放到容器里面
        this.doRegisterBeanDefinition(beanDefinitions);

        //4、把不是延迟加载的类，初始化
        this.doAutoWrited();
    }

    //只处理非延时加载的情况
    private void doAutoWrited() {
        for (Map.Entry<String, GPBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            if (!beanDefinitionEntry.getValue().isLazyInit()){
                this.getBean(beanName);
            }
        }
    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> beanDefinitions) throws Exception {
        for (GPBeanDefinition beanDefinition : beanDefinitions) {
            if (super.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())){
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + " is exists");
            }
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
        }
    }

    @Override
    public Object getBean(String beanName) {
        GPBeanDefinition beanDefinition = super.beanDefinitionMap.get(beanName);
        Object instance = instantiateBean(beanName, beanDefinition);
        GPBeanWrapper beanWrapper = new GPBeanWrapper(instance);
        this.factoryBeanInstanceCache.put(beanName, beanWrapper);
        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
    }

    private Object instantiateBean(String beanName, GPBeanDefinition beanDefinition){
        Object instance = null;
        try {
            String className = beanDefinition.getBeanClassName();//拿到要实例化对象的类名

            if (this.factoryBeanObjectCache.containsKey(className)){
                instance = this.factoryBeanObjectCache.get(className);
            } else {
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();
                this.factoryBeanObjectCache.put(className, instance);
                this.factoryBeanObjectCache.put(beanDefinition.getFactoryBeanName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    private void populateBean(String beanName, GPBeanDefinition beanDefinition, GPBeanWrapper beanWrapper){
        Object instance = beanWrapper.getWrappedInstance();
        Class<?> clazz = beanWrapper.getWrappedClass();
        //只有加了注解的类才进行依赖注入
        if (!(clazz.isAnnotationPresent(GPController.class) || clazz.isAnnotationPresent(GPService.class))){
            return;
        }
        //获得所有的fields
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(GPAutowired.class)) continue;
                GPAutowired autowired = field.getAnnotation(GPAutowired.class);
                String autowiredName = autowired.value().trim();
                if ("".equals(autowiredName)) {
                    autowiredName = field.getType().getName();
                }
                //强制访问
                field.setAccessible(true);
                if (this.factoryBeanInstanceCache.get(autowiredName) == null) continue;
                field.set(instance, this.factoryBeanInstanceCache.get(autowiredName).getWrappedInstance());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String[] getBeanDefinitionNames(){
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public Properties getConfig(){
        return this.reader.getConfig();
    }
}
