package course.springboot.config;

import course.springboot.component.BasicFilter;
import course.springboot.component.LoginInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.websocket.RemoteEndpoint;

@Configuration //==>beans.xml,可以设置类，也可以设置Filter
//@ServletComponentScan(basePackages = "course.springboot.component")
@EnableScheduling
public class BasicConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration=registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");
    }

    @Bean
    public FilterRegistrationBean<BasicFilter> basicFilter(){
        return new FilterRegistrationBean<>(new BasicFilter());

    }
}
