package com.gupaoedu.spring.framework.context;

import com.gupaoedu.spring.framework.beans.GPBeanDefinition;
import com.gupaoedu.spring.framework.beans.support.GPBeanDefinitionReader;
import com.gupaoedu.spring.framework.beans.support.GPDefaultListableBeanFactory;
import com.gupaoedu.spring.framework.core.GPBeanFactory;

import java.util.List;
import java.util.Map;

public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {

    private String[] configLocations;
    private GPBeanDefinitionReader reader;

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
        return null;
    }
}
