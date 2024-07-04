package com.onrender.henriquedev.portfolioapi.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/email/**")
                .allowedOrigins("https://henriquedev.vercel.app")
                .allowedMethods("POST", "OPTIONS")
                .allowedHeaders("*");
    }
}
