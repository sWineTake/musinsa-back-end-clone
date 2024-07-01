package com.example.testcode.ch04;

import com.example.testcode.ch04.domain.dto.Ticket;
import com.example.testcode.ch04.repository.ReservationRepository;
import com.example.testcode.ch04.service.PerformanceService;
import com.example.testcode.ch04.service.TicketingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class MockitoExampleTests {

	private TicketingService ticketingService;

	@Test
	void 티켓팅_테스트() {
		// given
		PerformanceService performanceService = Mockito.mock(PerformanceService.class);
		ReservationRepository reservationRepository = Mockito.mock(ReservationRepository.class);
		// 의존성 주입 - 목객체
		ticketingService = new TicketingService(performanceService, reservationRepository);
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

		// when
		Mockito.when(performanceService.isEnableReserve(any()))
			.then(invocation -> {
				System.out.println("Execute Mocking code");
				return "enable";
			});
		ticketingService.ticketing(ticket);

		// then 검증단계 - 호출여부, 호출횟수, 호출인자 등을 검증
		Mockito.verify(performanceService, Mockito.times(1)).isEnableReserve(any());
		Mockito.verify(reservationRepository, Mockito.times(1)).save(any());

	}

}
