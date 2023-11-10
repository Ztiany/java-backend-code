package me.ztiany.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WebDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDevApplication.class, args).getBean(WebDevApplication.class);
    }

}
