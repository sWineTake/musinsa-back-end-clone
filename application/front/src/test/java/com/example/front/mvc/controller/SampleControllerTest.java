package com.example.front.mvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(SampleController.class)
class SampleControllerTest {

	@Autowired
	private MockMvc mockMvc; // MockMvc 자동 주입



	@Test
	public void SAMPLE_컨트롤에_API를_확인할수있다() throws Exception {
		// given
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("Expected response"));

		// when


		// then


	}


}
