package com.poppy.ioc._3_componentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
/*@ComponentScan(value = "com.poppy.ioc._3_componentScan", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)},useDefaultFilters = false)*/
/*@ComponentScan(value = "com.poppy.ioc._3_componentScan", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)},useDefaultFilters = false)*/

/**
 * 可以配置自定义的FilterType.Custom【如：CustomTypeFilter】
 */
@ComponentScan(value = "com.poppy.ioc._3_componentScan")
public class OrderConfig {
}
