package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

@Order(2)
public class BeanB implements Rating {

    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
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

    private void customInitMethodB() {
        System.out.println("(BeanB)Inside customInitMethodB()");
    }

    private void customInitMethodBModified() {
        System.out.println("(BeanB)Inside customInitMethodBModified()");
    }

    private void customDestroyMethodB() {
        System.out.println("(BeanB)Inside customDestroyMethodB()");
    }

    @Override
    public String getRating() {
        return getClass().getName();
    }

}
