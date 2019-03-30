package com.poppy.ioc.xml;

import com.poppy.ioc.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);
    }
}
