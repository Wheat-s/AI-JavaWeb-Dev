package com.wheat.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // @Autowired
    // private DemoIntercepetor  demoIntercepetor;

    // @Autowired
    // private TokenIntercepetor tokenIntercepetor;
    //
    //
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(tokenIntercepetor)
    //             .addPathPatterns("/**") // 拦截所有请求
    //             .excludePathPatterns("/login"); // 不拦截哪些请求
    // }
}
