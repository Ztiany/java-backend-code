package me.ztiany.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import me.ztiany.springboot.web.bean.Administrator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/demo")
@Slf4j//Lombok 会自动注入 Slf4j 日志，属性名为 log。
public class DemoController {

    private final Administrator administrator;

    public DemoController(Administrator administrator) {
        this.administrator = administrator;
    }

    @GetMapping("/hello")
    public Administrator helloWorld() {
        log.debug("helloWorld was called.");
        return administrator;
    }

}
