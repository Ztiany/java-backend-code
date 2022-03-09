package me.ztiany.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *失效热更新：
 * 	1. Control + F9 可以重编译。
 *     2. 也可以配置 dev-tools 来实现自动重启。
 */
@SpringBootApplication
@Slf4j
public class WebDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDevApplication.class, args).getBean(WebDevApplication.class);
    }

}
