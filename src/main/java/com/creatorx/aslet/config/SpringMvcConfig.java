package com.creatorx.aslet.config;

import com.creatorx.aslet.dto.RequestMetadata;
import com.creatorx.aslet.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**");
    }

    @Bean
    @RequestScope
    public RequestMetadata getRequestMetadata() {
        return new RequestMetadata();
    }

    @Bean
    public JwtInterceptor getJwtInterceptor() {
        return new JwtInterceptor(getRequestMetadata());
    }
}
