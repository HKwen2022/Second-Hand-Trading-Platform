package com.mymarket.config;

import com.mymarket.interceptor.AdminLoginCheckInterceptor;
import com.mymarket.interceptor.UserLoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final UserLoginCheckInterceptor userLoginCheckInterceptor;
    private final AdminLoginCheckInterceptor adminLoginCheckInterceptor;
    public WebConfig(UserLoginCheckInterceptor userLoginCheckInterceptor, AdminLoginCheckInterceptor adminLoginCheckInterceptor) {
        this.userLoginCheckInterceptor = userLoginCheckInterceptor;
        this.adminLoginCheckInterceptor = adminLoginCheckInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/**");
        registry.addInterceptor(adminLoginCheckInterceptor).addPathPatterns("/admin/**");
    }
}
