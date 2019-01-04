package com.scm.configuration;

import com.scm.Interceptor.SessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.scm.controller")
public class WebConfig implements WebMvcConfigurer{
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/static/");
        resolver.setSuffix(".html");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() throws IOException{
        return new StandardServletMultipartResolver();
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        StringHttpMessageConverter shm = new StringHttpMessageConverter(Charset.forName("utf-8"));
//        converters.add(shm);
//    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 设置拦截的路径、不拦截的路径、优先级等等
//        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/*").excludePathPatterns("/scm");
//    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
