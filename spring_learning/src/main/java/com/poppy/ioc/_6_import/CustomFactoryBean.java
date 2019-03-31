package com.poppy.ioc._6_import;

import com.poppy.ioc._1_bean.Monkey;
import org.springframework.beans.factory.FactoryBean;

public class CustomFactoryBean implements FactoryBean<Monkey> {

    @Override
    public Monkey getObject() throws Exception {
        // TODO Auto-generated method stub
        return new Monkey();
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
