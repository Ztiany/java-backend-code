package me.ztiany.springboot.web.bean;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private int id;
    private int age;
    private String name;

}
