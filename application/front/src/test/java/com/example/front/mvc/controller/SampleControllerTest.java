package com.example.front.mvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/*
* Todo) 테스트 코드는 추후 작성 예정
* */
// @WebMvcTest(controllers = {SampleController.class})
// @TestPropertySource(locations="classpath:application.properties")
class SampleControllerTest {

	// @Autowired
	// private MockMvc mockMvc;

	// @Value("${server.servlet.context-path}")
	// private String contextPath;

	/*@Test
	public void API_CAN_CHECK() throws Exception {
		// given
		String url = contextPath + "/sample";

		// when
		ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get(url));

		// then
		perform.andExpect(MockMvcResultMatchers.status().isOk());
	}*/


}