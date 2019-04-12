package com.poppy.ioc._2_config_mode;

import com.poppy.ioc._1_bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseAnnoConfig {

    @Bean
    public Dog getDog(){
        return new Dog("汤圆");
    }

}
