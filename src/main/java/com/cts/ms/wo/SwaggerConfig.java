package com.cts.ms.wo;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String CONTROLLER = "com.cts.ms.wo.controller";
    public static final String PATH = "/*.*";

    @Bean
    public Docket workOrderAPI() {
        Predicate<RequestHandler> predicate = RequestHandlerSelectors.basePackage(CONTROLLER);
        return new Docket(DocumentationType.SWAGGER_2).select().apis(predicate).paths(regex(PATH)).build();
    }
}