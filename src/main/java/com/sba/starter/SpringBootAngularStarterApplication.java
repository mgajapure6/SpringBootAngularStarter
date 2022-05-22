package com.sba.starter;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@SpringBootApplication

public class SpringBootAngularStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularStarterApplication.class, args);
	}
	
	@Configuration
	public class MVCConfiguration implements WebMvcConfigurer{
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/")
			.addResourceLocations("classpath:/templates/index.html")
			.setCacheControl(CacheControl.noStore().mustRevalidate())
			.setCacheControl(CacheControl.noCache())
			.resourceChain(true).addResolver(new PathResourceResolver() {
				@Override
				protected Resource getResource(String resourcePath, Resource location) throws IOException {
					Resource resource  =  location.createRelative(resourcePath);
					return resource.exists() && resource.isReadable() ? resource : new ClassPathResource("/templates/index.html");
				}
			});
		}
	}

	
}
