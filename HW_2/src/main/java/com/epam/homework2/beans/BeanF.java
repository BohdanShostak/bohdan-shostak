package com.epam.homework2.beans;

public class BeanF implements Rating {

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
    public String getRating() {
        return getClass().getName();
    }

}
