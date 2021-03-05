package com.claiire.demo.config;

import com.claiire.demo.common.DemoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈拦截器配置类〉
 *
 * @author Claire
 * @create 2021/3/4
 * @since 1.0.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Autowired
    private DemoInterceptor demoInterceptor;

    //添加静态资源
    @Override
    public void  addResourceHandlers(ResourceHandlerRegistry registry){

    }
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/User/login")//过滤拦截器，可设置多个，这里如果拦截器处是false，这里会使其正常实现
        ;
    }
    //解决添加拦截器后的乱码问题
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(messageConverter());//添加转换器的bean
    }
    //轉換方法
    @Bean
    public HttpMessageConverter<String> messageConverter(){
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));//字符串的轉換器，轉換編碼集
    }

}
