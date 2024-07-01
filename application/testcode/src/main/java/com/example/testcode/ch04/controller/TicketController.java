package com.example.testcode.ch04.controller;

import com.example.testcode.ch04.domain.dto.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TicketController {

	@PostMapping("/reserve")
	public ResponseEntity<Ticket> reservation() throws Exception{
		Ticket ticket = Ticket.builder()
			.performanceId(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"))
			.performanceName("레베카")
			.reservationName("홍길동")
			.reservationPhoneNumber("010-1234-5678")
			.round(1)
			.line('A')
			.seat(1)
			//.appliedPolicies(Arrays.asList(new String[]{"telecome"}))
			.build();

		System.out.println("reservation");

		return ResponseEntity.ok().body(ticket);
	}


}
