package com.poppy.ioc._6_import;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void beans() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Object bean1 = context.getBean(CustomFactoryBean.class);
        Object bean2 = context.getBean(CustomFactoryBean.class);//取Money
        System.out.println("bean的类型="+bean1.getClass());
        System.out.println(bean1 == bean2);

        String[] beans = context.getBeanDefinitionNames();
        for (String b : beans) {
            System.out.println(b);//全路径：com.poppy.ioc._1_pojo.Dog
        }
    }

}