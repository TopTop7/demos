package com.poppy.ioc._6_import;

import com.poppy.ioc._1_bean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/*
	*AnnotationMetadata:当前类的注解信息
	*BeanDefinitionRegistry:BeanDefinition注册类
	*    把所有需要添加到容器中的bean加入;
	*    @Scope
	*/
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean bean1 = registry.containsBeanDefinition("com.poppy.ioc._1_bean.Dog");
		boolean bean2 = registry.containsBeanDefinition("com.poppy.ioc._1_bean.Cat");
		//如果Dog和Cat同时存在于我们IOC容器中,那么创建Pig类, 加入到容器
		//对于我们要注册的bean, 给bean进行封装,
		if(bean1 && bean2){
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
			//注册的bean是简单类型，不是全路径
			registry.registerBeanDefinition("pig", beanDefinition);
		}
	}

}
