package me.ztiany.springboot.web.bean;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HttpError {

    private int code;
    private String msg;

}
