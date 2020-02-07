package com.ldg.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.ldg.blog.aop.SessionIntercepter;


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
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//interceptor 만들기
		registry.addInterceptor(new SessionIntercepter())
		                             // ** 그 뒤는 상관없다
		.addPathPatterns("/user/profile/**")
		.addPathPatterns("/post/write/**")
		.addPathPatterns("/post/update/**")
		.addPathPatterns("/post/delete/**");
		
//		.excludePathPatterns("/post/**")제외시킬 때 사용
		
	}
	
	
}
