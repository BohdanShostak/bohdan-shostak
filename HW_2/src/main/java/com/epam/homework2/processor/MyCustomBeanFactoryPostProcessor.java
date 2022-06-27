package com.epam.homework2.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyCustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("________Inside_BeanFactoryPostProcessor___________");
        String[] beanStr = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanStr) {
            if ("getBeanB".equals(beanName)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                beanDefinition.setInitMethodName("customInitMethodBModified");
            }
        }
    }

}
