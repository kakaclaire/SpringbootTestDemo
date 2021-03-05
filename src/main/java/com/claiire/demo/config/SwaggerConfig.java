package com.claiire.demo.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Parameter;

/**
 * 〈一句话功能简述〉<br>
 * 〈swagger配置类〉
 *
 * @author Claire
 * @create 2021/3/3
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        ParameterBuilder builder=new ParameterBuilder();
        builder.parameterType("header")
                .name("token")
                .description("token值")
                .required(true)
                .modelRef(new ModelRef("String"));//在swagger中显示header
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user_interface")
                .apiInfo(apiInfo())
                .globalOperationParameters(Lists.newArrayList(builder.build()))
                .select().paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("user系统")
                .description("user接口文档")
                .contact(new Contact("claire","","1111111"))
                .version("1.0")
                .build();
    }

}
