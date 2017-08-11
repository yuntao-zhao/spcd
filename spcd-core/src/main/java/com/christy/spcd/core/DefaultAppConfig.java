package com.christy.spcd.core;

import org.springframework.context.annotation.Bean;

public class DefaultAppConfig {

	@Bean
	public SpringFactory springFactory(){
		return new SpringFactory();
	}
}
