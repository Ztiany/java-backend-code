package me.ztiany.springboot.web.bean;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Pet {

    private String name;
    private Integer age;

}