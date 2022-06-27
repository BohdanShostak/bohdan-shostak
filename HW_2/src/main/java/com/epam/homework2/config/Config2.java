package com.epam.homework2.config;

import com.epam.homework2.beans.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = "com.epam.homework2.beans")
public class Config2 {

    @Bean
    @Lazy
    public BeanF getBeanF() {
        return new BeanF();
    }

}
