package com.epam.homework2.config;

import com.epam.homework2.beans.*;
import com.epam.homework2.processor.MyCustomBeanFactoryPostProcessor;
import com.epam.homework2.processor.MyCustomBeanPostProcessor;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.epam.homework2.beans")
@PropertySource("application.properties")
@Import(Config2.class)
public class Config1 {

    @Bean
    public GeneralBean getGeneralBean() {
        return new GeneralBean();
    }

    @Bean(initMethod = "customInitMethodD",
            destroyMethod = "customDestroyMethodD")
    public BeanD getBeanD() {
        return new BeanD();
    }

    @Bean(initMethod = "customInitMethodB",
            destroyMethod = "customDestroyMethodB")
    public BeanB getBeanB() {
        return new BeanB();
    }

    @Bean(initMethod = "customInitMethodC",
            destroyMethod = "customDestroyMethodC")
    public BeanC getBeanC() {
        return new BeanC();
    }

    @Bean
    public BeanA getBeanA() {
        return new BeanA();
    }

    @Bean
    public BeanE getBeanE() {
        return new BeanE();
    }

    @Bean
    public MyCustomBeanPostProcessor beanPostProcessor() {
        return new MyCustomBeanPostProcessor();
    }

    @Bean
    MyCustomBeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new MyCustomBeanFactoryPostProcessor();
    }

}
