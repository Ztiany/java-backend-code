package me.ztiany.springboot.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
public class GetStartedApplication {

    @Resource(name = "defaultExecutor")
    private Executor executor;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GetStartedApplication.class, args);
        applicationContext.getBean(GetStartedApplication.class).start();
    }

    private void start() {
        executor.doAction(() -> System.out.println("Started"));
    }

}