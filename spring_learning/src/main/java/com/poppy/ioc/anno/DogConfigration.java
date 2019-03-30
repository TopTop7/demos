package com.poppy.ioc.anno;

import com.poppy.ioc.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfigration {

    @Bean
    public Dog getDog(){
        return new Dog("汤圆");
    }
}
