package org.wheat;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {

    /**
     * 方式一：HttpServletResponse 设置响应数据
     * @param response
     * @throws IOException
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        // 1. 设置响应状态码
        response.setStatus(HttpServletResponse.SC_OK);
        // 2. 设置响应头
        response.setHeader("name", " wheat");
        // 3. 设置响应体
        response.getWriter().write("<h1>Hello Wheat.</h1>");
    }

    /**
     * 方式2: ResponseEntity - Spring 中提供的方式
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity
                .status(200)
                .header("name", "javaweb-ai")
                .body("<h1>Hello Wheat.</h1>");
    }
}
