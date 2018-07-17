package com.santander.crm.sinergia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
//                "/image/**",
                "/img/**",
                "**/swagger-ui.html"
                )
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
//                        "classpath:/image/",
                        "classpath:/img/",
                        "classpath:/META-INF/resources/"
                        );
    }

}
