package com.gupaoedu.spring.framework.beans.support;

import com.gupaoedu.spring.framework.beans.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GPBeanDefinitionReader {

    private List<String> registryBeanClasses = new ArrayList<>();

    private Properties config = new Properties();

    private final String SCAN_PACKAGE = "scanPackage";

    public GPBeanDefinitionReader(String... locations) {
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""))) {
            config.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.", ""));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()){
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) continue;
                String className = scanPackage + "." + file.getName().replace(".class", "");
                registryBeanClasses.add(className);
            }
        }
    }

    public Properties getConfig() {
        return config;
    }

    /**
     * 把配置文件中扫描到的所有的配置信息转换为BeanDefinition对象，以便于之后IOC操作方便
     */
    public List<GPBeanDefinition> loadBeanDefinitions(){
        List<GPBeanDefinition> result = new ArrayList<>();
        try {
            for (String className : registryBeanClasses) {
                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()) continue;
                result.add(this.doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()), beanClass.getName()));
                for (Class<?> clazz : beanClass.getInterfaces()) {
                    result.add(doCreateBeanDefinition(clazz.getName(), beanClass.getName()));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 把一个配置信息解析成一个BeanDefinition
     */
    private GPBeanDefinition doCreateBeanDefinition(String factoryBeanName, String beanClassname){
        GPBeanDefinition beanDefinition = new GPBeanDefinition();
        beanDefinition.setBeanClassName(beanClassname);
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }

    private String toLowerFirstCase(String simpleName){
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
