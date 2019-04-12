package com.poppy.ioc._6_import;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata){
		//返回全类名的bean
		return new String[]{"com.poppy.ioc._1_bean.Fish","com.poppy.ioc._1_bean.Cat"};
	}
}
