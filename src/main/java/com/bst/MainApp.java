package com.bst;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class MainApp  extends SpringBootServletInitializer {

	   @Override
	   protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
	       return builder.sources(MainApp.class);
	   }

	   public static void main (String[] args) {
	       SpringApplication app = new SpringApplication(MainApp.class);
	       app.run(args);
	   }
}
	   
	
