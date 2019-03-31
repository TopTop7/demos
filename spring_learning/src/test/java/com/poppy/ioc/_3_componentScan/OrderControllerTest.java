package com.poppy.ioc._3_componentScan;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    ApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(OrderConfig.class);
        String[] beans = context.getBeanDefinitionNames();
        for (String b : beans) {
            System.out.println(b);
        }
    }

    @Test
    public void getName() {
        OrderController controller = context.getBean(OrderController.class);
        //System.out.println(controller.getName());

        //System.out.println(orderController.getName());
    }
}