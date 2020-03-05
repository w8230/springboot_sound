package com.sound.door.Application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.sound.door.BootApplication;

@SpringBootApplication
public class ServletApplication extends SpringBootServletInitializer{
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(new Class[]{BootApplication.class});
    }
}
