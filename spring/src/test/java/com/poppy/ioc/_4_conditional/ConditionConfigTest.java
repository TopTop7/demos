package com.poppy.ioc._4_conditional;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionConfigTest {
    @Test
    public void person() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        String[] beans = context.getBeanDefinitionNames();
        for (String b : beans) {
            System.out.println(b);
        }
    }

}