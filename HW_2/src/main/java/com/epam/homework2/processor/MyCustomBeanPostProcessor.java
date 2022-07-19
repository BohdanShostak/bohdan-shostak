package com.epam.homework2.processor;

import com.epam.homework2.beans.Rating;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyCustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("postProcessBeforeInitialization( beanToString: " + bean.toString() + " beanName: " + beanName + ")");
        if (bean instanceof Rating) {
            String name = ((Rating) bean).getName();
            int value = ((Rating) bean).getValue();
            if (name == null) {
                ((Rating) bean).setName("DefaultName");
            }
            if (value <= 0) {
                ((Rating) bean).setValue((int) (Math.random() * 10));
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("postProcessAfterInitialization( beanToString: " + bean.toString() + " beanName: " + beanName + ")");
        return bean;
    }

}
