package com.ldg.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;




@Configuration					 // WebMvcConfigurer web.xml  servlet context 같은 파일
public class WebConfig implements WebMvcConfigurer {
	@Value("${file.path}")
	private String fileRealPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
		WebMvcConfigurer.super.addResourceHandlers(registry);			
                                
		registry.addResourceHandler("/media/**")
		.addResourceLocations("file:///"+fileRealPath)		
		.setCachePeriod(3600)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
		
	}
	

	
	
}
