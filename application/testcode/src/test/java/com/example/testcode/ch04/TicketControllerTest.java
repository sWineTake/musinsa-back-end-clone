package com.example.testcode.ch04;

import com.example.testcode.ch04.controller.TicketController;
import com.example.testcode.ch04.service.TicketingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicketController.class)
public class TicketControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	TicketingService ticketingService;

	@DisplayName("티켓 예약 컨트롤러 테스트")
	@Test
	public void setTicketingService() throws Exception{
		String contents = "test";

		mockMvc.perform(get("/ticket"))
			.andExpect(status().isOk())
			.andExpect(content().string(contents));
	}

}
