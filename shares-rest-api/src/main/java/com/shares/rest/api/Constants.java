package com.shares.rest.api;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class Constants implements EnvironmentAware {
	
	private static Environment environment;

	@Override
	public void setEnvironment(Environment environment) {
		Constants.environment = environment;		
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
	
	public static String getHeader() {
		return environment.getProperty("jwt.header");
	}
	
	public static String getPrefix() {
		return environment.getProperty("jwt.prefix");
	}
	
	public static String getSecretKey() {
		return environment.getProperty("jwt.secret.key");
	}
}
