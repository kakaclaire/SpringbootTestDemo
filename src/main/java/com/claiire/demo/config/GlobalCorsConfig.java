package com.claiire.demo.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * 〈一句话功能简述〉<br>
 * 〈跨域配置〉
 *
 * @author Claire
 * @create 2021/3/4
 * @since 1.0.0
 */
@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config=new CorsConfiguration();
        config.setAllowCredentials(true);//允许cookies跨域
        config.addAllowedOrigin("*");//允许向该服务器提交请求的URI。*表示全部允许
        config.addAllowedHeader("*");//允许访问的头信息
        config.setMaxAge(18000L);//预检请求的缓存时间（秒），在这个时间段里，对于相同的跨域请求不会再预检了
        config.addAllowedMethod("POST");//向指定资源提交数据进行处理请求（例如提交表单或者上传文件）。数据被包含在请求体中。POST 请求可能会导致新的资源的建立和/或已有资源的修改。
        config.addAllowedMethod("GET");//请求指定的页面信息，并返回实体主体。
        config.addAllowedMethod("PUT");//从客户端向服务器传送的数据取代指定的文档的内容。
        config.addAllowedMethod("DELETE");//请求服务器删除指定的页面
        config.addAllowedMethod("HEAD");//类似于 GET 请求，只不过返回的响应中没有具体的内容，用于获取报头
        config.addAllowedMethod("OPTIONS");//允许客户端查看服务器的性能。
        config.addAllowedMethod("PATCH");//是对 PUT 方法的补充，用来对已知资源进行局部更新 。
        config.addAllowedMethod("TRACE");//回显服务器收到的请求，主要用于测试或诊断。
        source.registerCorsConfiguration("/**",config);//注册一下配置项
        return new CorsFilter(source);
    }

}
