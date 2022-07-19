package com.epam.homework2.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements Rating {

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

    @PostConstruct
    public void postConstruct() {
        System.out.println("(BeanE)Inside @PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("(BeanE)Inside @preDestroy");
    }

    @Override
    public String getRating() {
        return getClass().getName();
    }

}
