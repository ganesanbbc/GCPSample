package com.cts.ms.wo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WorkEngineApp {
	
	String ORGIN_URL = "https://customermssample.appspot.com";

	public static void main(String[] args) {
		SpringApplication.run(WorkEngineApp.class, args);
	}
	
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(ServiceEndPoint.POST_ORDERS).allowedOrigins("*");
            }
        };
    }
}
