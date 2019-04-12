package com.poppy.ioc._2_config_mode;

import com.poppy.ioc._1_bean.Dog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class UseAnnoConfigTest {
    @Test
    public void getDog() {
        ApplicationContext context = new AnnotationConfigApplicationContext(UseAnnoConfig.class);
        Dog dog = (Dog) context.getBean("getDog");
        System.out.println(dog);
    }

}