package it.naveen.educationapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Autowired
    private CorsConfigProperties corsConfigProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(corsConfigProperties.getAllowedOrgin())
                .allowedMethods(corsConfigProperties.getAllowedMethods())
                .allowCredentials(corsConfigProperties.isAllowCredentials())
                .maxAge(corsConfigProperties.getMaxAge());
    }
}
