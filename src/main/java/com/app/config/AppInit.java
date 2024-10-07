package com.app.config;

import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.MultipartConfigElement;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement("E:\\SpringPrograms\\SpringRestApplication13\\src\\main\\webapp\\temp", 2097152, 4194304, 0);
        registration.setMultipartConfig(multipartConfigElement);
	}

}
