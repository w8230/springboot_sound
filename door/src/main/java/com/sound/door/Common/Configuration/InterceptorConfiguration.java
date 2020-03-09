package com.sound.door.Common.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.sound.door.Common.Interceptor.Handler;

/**
 * <javadoc>
 * 인터셉터 핸들러
 * @author      김재일
 * @version     1.0
 * @since       2020-03-10
 **/
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{

    @Autowired
    private Handler handler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handler)
                .addPathPatterns("/*")
                .excludePathPatterns("/login")
        		.excludePathPatterns("/validUser");

    }
}
