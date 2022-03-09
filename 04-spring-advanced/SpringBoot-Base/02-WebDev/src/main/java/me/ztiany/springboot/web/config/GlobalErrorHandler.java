package me.ztiany.springboot.web.config;

import lombok.extern.slf4j.Slf4j;
import me.ztiany.springboot.web.bean.HttpError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler({NullPointerException.class})
    @ResponseBody
    public HttpError handleException1(Exception e) {
        return new HttpError(20, e.getMessage());//json
    }

    @ExceptionHandler({ArithmeticException.class})
    public String handleException2(Exception e) {
        return "forward:/error";//error 视图
    }

}
