package com.poppy.ioc.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
/*@ComponentScan(value = "com.poppy.ioc.scan", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)},useDefaultFilters = false)*/
/*@ComponentScan(value = "com.poppy.ioc.scan", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)},useDefaultFilters = false)*/
@ComponentScan(value = "com.poppy.ioc.scan")
public class OrderConfig {
}
