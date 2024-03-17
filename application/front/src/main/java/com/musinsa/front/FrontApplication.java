package com.musinsa.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"com.musinsa.front", "com.musinsa.util"})
@PropertySources({
	@PropertySource("classpath:/application-${spring.profiles.active}.properties"),
	@PropertySource("classpath:/globals/globals-${spring.profiles.active}.properties")
})
public class FrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontApplication.class, args);
	}

}
