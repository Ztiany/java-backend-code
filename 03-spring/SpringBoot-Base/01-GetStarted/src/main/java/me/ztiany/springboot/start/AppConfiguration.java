package me.ztiany.springboot.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ForkJoinPool;

@Configuration
public class AppConfiguration {

    @Bean
    public Executor defaultExecutor() {
        return runnable -> ForkJoinPool.commonPool().execute(runnable);
    }

}
