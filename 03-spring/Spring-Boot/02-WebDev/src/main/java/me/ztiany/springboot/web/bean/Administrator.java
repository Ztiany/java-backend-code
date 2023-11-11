package me.ztiany.springboot.web.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
@ConfigurationProperties(prefix = "beans.administrator")
@PropertySource(value = {"classpath:beans.properties"})// PropertySource 只支持 properties 文件。
public class Administrator {

    private String name;
    private String password;
    private int age;

}