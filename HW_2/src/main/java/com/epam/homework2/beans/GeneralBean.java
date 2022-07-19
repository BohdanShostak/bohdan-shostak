package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GeneralBean {

    @Autowired
    private List<Rating> threeBeans;

    public void printOrderedBeans() {
        for (Rating rating : threeBeans) {
            System.out.println(rating.getRating());
        }
    }

}
