package com.musinsa.front.mvc.config.controller;

import com.musinsa.origindb.mvc.service.SampleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringControllerConfig {

	@Bean
	public SampleService getSampleService() {
		return new SampleService();
	}


}
