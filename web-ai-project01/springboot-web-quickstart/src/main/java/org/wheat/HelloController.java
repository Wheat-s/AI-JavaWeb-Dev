package org.wheat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 表示当前类是一个请求处理类
public class HelloController {
    @RequestMapping("/hello") // 表示请求路径
    public String hello(String name) {
        System.out.println("name: " + name);
        return "hello " + name + "~~";
    }
}
