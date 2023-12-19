package com.cumt.atmsystem.tools;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/**") // 允许跨域访问的路径
//                .allowedOrigins("*") // 允许访问的源
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // 允许请求的方法
//                .allowedHeaders("*") // 允许的头信息
//                .allowCredentials(true) // 是否允许证书（cookies）
//                .maxAge(3600); // 本次验证的有效时长（秒）
//    }
}

