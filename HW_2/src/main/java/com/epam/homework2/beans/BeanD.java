package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

@Order(1)
public class BeanD implements Rating {

    @Value("${beanD.name}")
    private String name;

    @Value("${beanD.value}")
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

    private void customInitMethodD() {
        System.out.println("(BeanD)Inside customInitMethodD()");
    }

    private void customDestroyMethodD() {
        System.out.println("(BeanD)Inside customDestroyMethodD()");
    }

    @Override
    public String getRating() {
        return getClass().getName();
    }

}
