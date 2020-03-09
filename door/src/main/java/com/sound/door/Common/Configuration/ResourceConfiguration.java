package com.sound.door.Common.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <javadoc>
 * 파일 리소스 핸들러
 * @author      김재일
 * @version     1.0
 * @since       2020-03-10
 **/
@Configuration
public class ResourceConfiguration implements WebMvcConfigurer{

    @Value("${resources.location}")
    private String resourcesLocation;
    @Value("${resources.uri_path:}")
    private String resourcesUriPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcesUriPath + "/**")
                .addResourceLocations("file://" + resourcesLocation);
    }
}
