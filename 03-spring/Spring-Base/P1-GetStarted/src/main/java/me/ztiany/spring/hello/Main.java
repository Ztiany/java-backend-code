package me.ztiany.spring.hello;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

public class Main {

    @Resource(name = "providePerson")
    private Person person;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocBaseConfig.class);
        Main main = (Main) applicationContext.getBean("provideMain");
        main.run();
    }

    private void run() {
        System.out.println(person.getName());
    }

}
