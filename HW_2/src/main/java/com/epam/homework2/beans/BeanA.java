package com.epam.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA implements InitializingBean, DisposableBean, Rating {

    private String name;
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

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("(BeanA)Inside InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("(BeanA)Inside DisposableBean.destroy()");
    }

    @Override
    public String getRating() {
        return getClass().getName();
    }

}
