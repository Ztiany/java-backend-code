package com.atguigu.springmvc.crud.handlers.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SpringMVCTestExceptionHandler {

    /**
     * ExceptionHandler 标注的方法可以返回 ModelAndView，或者返回 String 来表示 View；也可以在方法上加上 ResponseBody 来返回 Json 等数据。
     */
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex) {
        System.out.println("----> called in SpringMVCTestExceptionHandler 出异常了: " + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }

}
