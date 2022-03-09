package me.ztiany.spring.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IocBaseConfig {

    /*bean id 默认是方法名*/
    @Bean
    public Person providePerson() {
        System.out.println("providePerson");
        return new Person();
    }

    @Bean
    public Main provideMain() {
        System.out.println("provideMain");
        return new Main();
    }

}