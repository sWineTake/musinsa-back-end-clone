package com.musinsa.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
	@PropertySource("classpath:/application-${spring.profiles.active}.properties")
})
// @MapperScan(basePackages = "*")
public class FrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontApplication.class, args);
	}

}
