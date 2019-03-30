package com.poppy.ioc.anno;

import com.poppy.ioc.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DogConfigration.class);
        Dog dog = (Dog) context.getBean("getDog");
        System.out.println(dog);
    }
}
