package com.example.shopproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")  // 모든 요청에 대해 CORS 허용
                .allowedOrigins("http://localhost:3000", "http://localhost:3001")    // 리액트 url 주소
//                .allowedOrigins("/**")    // 리액트 url 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // OPTIONS 추가: preflight 요청 허용
                .allowedHeaders("*")        // 모든 header 허용
                .allowCredentials(true);    // 쿠키를 주고 받을 수 있게 설정

    }
}
