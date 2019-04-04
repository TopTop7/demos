package com.poppy.ioc._2_config_mode;

import com.poppy.ioc._1_bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class UseXmlConfig {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        new FileSystemXmlApplicationContext("");
        Dog dog = (Dog) context.getBean("dog");
        Dog dog1 = context.getBean(Dog.class);//推荐使用
        System.out.println(dog);
        System.out.println(dog1);
    }
}
