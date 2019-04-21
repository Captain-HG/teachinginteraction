package com.lzc.teachingInteraction.config;


import com.lzc.teachingInteraction.utils.UploadUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ UploadUtil.getUploadFilePath()+"upload/");
        super.addResourceHandlers(registry);
    }
}
