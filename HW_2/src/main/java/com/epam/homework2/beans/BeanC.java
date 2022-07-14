package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

@Order(3)
public class BeanC implements Rating {

    @Value("${beanC.name}")
    private String name;

    @Value("${beanC.value}")
    private int value;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + " " + value;
    }

    private void customInitMethodC() {
        System.out.println("(BeanC)Inside customInitMethodC()");
    }

    private void customDestroyMethodC() {
        System.out.println("(BeanC)Inside customDestroyMethodC()");
    }

    @Override
    public String getRating() {
        return getClass().getName();
    }

}
