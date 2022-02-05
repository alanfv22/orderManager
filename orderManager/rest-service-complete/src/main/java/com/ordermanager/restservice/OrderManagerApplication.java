package com.ordermanager.restservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.Base64;

@SpringBootApplication
@EntityScan("com.ordermanager.repository.entities")
@ComponentScan({"com.ordermanager.services", "com.ordermanager.restservice"})
@EnableJpaRepositories("com.ordermanager.repository.repositories")

public class OrderManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagerApplication.class, args);
        
      
        
        
    }

   

    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				
				/*
				registry.addMapping(ApplicationConstants.ORDERS_ROUTE).allowedOrigins("http://localhost:8080");
				registry.addMapping(ApplicationConstants.LOGIN_ROUTE).allowedOrigins("http://localhost:8080");
				registry.addMapping(ApplicationConstants.USERS_ROUTE).allowedOrigins("*");
				
				
				registry.addMapping("/**").allowedOrigins("*");
				*/
				
			}
			
			
		};
	}
	
	
}
