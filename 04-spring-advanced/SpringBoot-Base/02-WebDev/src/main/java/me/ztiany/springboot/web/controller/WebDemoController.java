package me.ztiany.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import me.ztiany.springboot.web.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class WebDemoController {

    @ResponseBody
    @GetMapping("/user")
    public String getUser() {
        log.debug("WebDemoController.getUser()");
        return "GET-getUser";
    }

    @PostMapping("/user")
    @ResponseBody
    public String saveUser() {
        return "POST-saveUser";
    }

    @ResponseBody
    @PutMapping("/user")
    public String putUser() {
        return "PUT-putUser";
    }

    @ResponseBody
    @DeleteMapping("/user")
    public String deleteUser() {
        return "DELETE-deleteUser";
    }

    /**
     * 数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定。
     */
    @ResponseBody
    @PostMapping("/saveUser")
    public Person saveUser(Person person) {
        log.debug("person = " + person);
        return person;
    }

    /**
     * 数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定。
     */
    @ResponseBody
    @PostMapping("/saveUser/json")
    public Person saveUserByJson(@RequestBody Person person) {
        log.debug("person = " + person);
        return person;
    }

    // 参数：car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    @ResponseBody
    public Map<String, Object> getCar(
            @PathVariable("id") Integer id,
            @PathVariable("username") String name,
            @PathVariable Map<String, String> pv,
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader Map<String, String> header,
            @RequestParam("age") Integer age,
            @RequestParam("inters") List<String> inters,
            @RequestParam Map<String, String> params,
            @CookieValue(value = "_ga", required = false) String _ga,
            @CookieValue(value = "_ga", required = false) Cookie cookie
    ) {
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("headers", header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("_ga", _ga == null ? "no_ga" : _ga);
        map.put("_ga_cookie", cookie == null ? "no_ga_cookie" : cookie.getValue());

        return map;
    }

    @PostMapping("/save")
    @ResponseBody
    public Map postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    /*
        1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
        2、SpringBoot 默认是禁用了矩阵变量的功能，开启方法是注入自己的 UrlPathHelper 对象，并设置 removeSemicolonContent = false。
        3、矩阵变量必须有 url 路径变量才能被解析。
     */
    @GetMapping("/cars/{path}")
    @ResponseBody
    public Map carsSell(
            @MatrixVariable("low") Integer low,
            @MatrixVariable("brand") List<String> brand,
            @PathVariable("path") String path
    ) {

        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);

        return map;
    }

    // 参数：/boss/1;age=20/2;age=10
    @ResponseBody
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(
            @MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
            @MatrixVariable(value = "age", pathVar = "empId") Integer empAge
    ) {
        Map<String, Object> map = new HashMap<>();

        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg", required = false) String msg, @RequestAttribute(value = "code", required = false) Integer code, HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");

        Map<String, Object> map = new HashMap<>();
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("reqMethod_msg", msg1);
        map.put("annotation_msg", msg);
        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);

        return map;
    }

    /**
     * 1、浏览器发请求直接返回 xml    [application/xml]        jacksonXmlConverter
     * 2、如果是 ajax 请求返回 json   [application/json]      jacksonJsonConverter
     * 3、如果 app 发请求，返回自定义协议数据  [appliaction/x-guigu]   xxxxConverter【如果有定义协议的话】
     *
     * <p>
     * 步骤：
     * 1、添加自定义的 MessageConverter 进系统底层。
     * 2、系统底层就会统计出所有 MessageConverter 能操作哪些类型。
     * 3、客户端内容协商 [guigu--->guigu]。
     * <p>
     * 扩展：如何以参数的方式进行内容协商？
     */
    @ResponseBody  //利用返回值处理器里面的消息转换器进行处理
    @GetMapping(value = "/test/person")
    public Person getPerson() {
        log.debug("WebDemoController.getPerson()");
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了...");
        request.setAttribute("code", 200);
        //去到模板文件夹里的 success 页面
        return "forward:/success";
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map, Model model, HttpServletRequest request, HttpServletResponse response) {
        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "HelloWorld");

        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);
        //去到模板文件夹里的 success 页面
        return "forward:/success";
    }

}