package com.epam.homework2;

import com.epam.homework2.beans.GeneralBean;
import com.epam.homework2.beans.Rating;
import com.epam.homework2.config.Config1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Homework2Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework2Application.class, args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config1.class);

        System.out.println("___Order of creation beans: D-> B-> C_Other__");
        context.getBean(GeneralBean.class).printOrderedBeans();

        System.out.println("___List of all beans___");
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        System.out.println("---Configuration of all beans---");
        for (String beanName2 : beanNames) {
            System.out.println(context.getBeanDefinition(beanName2));
            if (context.getBean(beanName2) instanceof Rating) {
                System.out.println(((Rating) context.getBean(beanName2)).getName());
                System.out.println(((Rating) context.getBean(beanName2)).getValue());
            }
        }
        context.close();
    }

}
