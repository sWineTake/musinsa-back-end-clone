package com.example.front.mvc.controller;

import com.example.origindb.mvc.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

	private final SampleService sampleService;

	@GetMapping("/sample")
	public String apiTest() {
		return sampleService.test();
	}

}
