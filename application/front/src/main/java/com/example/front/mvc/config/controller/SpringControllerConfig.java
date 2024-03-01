package com.example.front.mvc.config.controller;

import com.example.origindb.mvc.service.SampleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringControllerConfig {

	@Bean
	public SampleService getSampleService() {
		return new SampleService();
	}

}
