package me.ztiany.springboot.web.bean;

import lombok.*;

import javax.persistence.*;

//使用 JPA 注解配置映射关系
@Entity
//@Table 来指定和哪个数据表对应，如果省略默认表名就是 user；
@Table(name = "tbl_student")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    //这是和数据表对应的一个列
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column //省略默认列名就是属性名
    private String email;

}