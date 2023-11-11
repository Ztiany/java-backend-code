package me.ztiany.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import me.ztiany.springboot.web.bean.Administrator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// RestController = @Controller + @ResponseBody
@Controller
@RequestMapping("/demo")
//Lombok 会自动注入 Slf4j 日志，属性名为 log。
@Slf4j
public class DemoController {

    private final Administrator administrator;

    public DemoController(Administrator administrator) {
        this.administrator = administrator;
    }

    @GetMapping("/hello")
    @ResponseBody
    public Administrator helloWorld() {
        log.debug("helloWorld was called.");
        return administrator;
    }

    @GetMapping("/helloDispatch")
    public String testDispatch() {
        log.debug("helloWorld was called.");
        return "forward:/demo/hello";
    }

}
