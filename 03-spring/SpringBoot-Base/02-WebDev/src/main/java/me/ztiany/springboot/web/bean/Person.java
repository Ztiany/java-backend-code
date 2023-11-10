package me.ztiany.springboot.web.bean;

import lombok.*;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}