package com.wheat.filter;

import com.wheat.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        // 强转成HttpServletRequest和HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) servletRequest; //
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取请求路径url.
        String url = request.getRequestURI(); // /login

        //2.判断请求url中是否包含login, 如果包含, 说明是登录操作, 直接放行.
        if (url.contains("login")) {
            log.info("登录请求, 放行...");
            filterChain.doFilter(request, response);
            return;
        }

        //3.获取请求头重的令牌(token).
        String token = request.getHeader("token");

        //4.判断令牌是否为空, 如果为空, 响应401.
        if (token == null || token.isEmpty()) {
            log.info("令牌为空, 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //5.解析token, 如果解析失败, 响应401
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法, 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //6.放行.
        log.info("令牌合法, 放行...");
        filterChain.doFilter(request, response);
    }
}
