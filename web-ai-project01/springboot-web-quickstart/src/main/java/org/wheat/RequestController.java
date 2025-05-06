package org.wheat;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        // 1. 获取请求方式
        String method = request.getMethod();
        System.out.println("method: " + method);

        // 2. 获取请求URL地址
        String url = request.getRequestURL().toString();
        System.out.println("url: " + url);

        String requestURI = request.getRequestURI();
        System.out.println("requestURI: " + requestURI);

        // 3. 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("protocol: " + protocol);

        // 4. 获取请求参数 - name - age
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name: " + name + " age: " + age);

        // 5. 获取请求头 - Accept
        String accept = request.getHeader("Accept");
        System.out.println("accept: " + accept);

        return "ok";

    }

}
