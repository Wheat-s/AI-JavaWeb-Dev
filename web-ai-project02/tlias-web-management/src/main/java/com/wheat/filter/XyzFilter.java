package com.wheat.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter (urlPatterns = "/*")
public class XyzFilter implements Filter {

    //过滤器初始化方法, web服务器启动时, 只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法...");
    }

    // 过滤方法, 每一次请求时, 都会执行一次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到请求...");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    // 销毁方法, web服务器关闭时, 只执行一次
    @Override
    public void destroy() {
        log.info("destroy 销毁方法...");
    }
}
