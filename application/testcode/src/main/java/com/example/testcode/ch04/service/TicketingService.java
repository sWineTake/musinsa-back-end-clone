package com.example.testcode.ch04.service;

import com.example.testcode.ch04.domain.dto.Ticket;
import com.example.testcode.ch04.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TicketingService {

	private final PerformanceService performanceService;
	private final ReservationRepository reservationRepository;

	public Ticket ticketing(Ticket t) {
		if ("enable".equals(performanceService.isEnableReserve(t.getPerformanceId()))) {
			reserve(t);
			return t;
		}
		throw new NoSuchElementException("예약 가능한 공연이 아닙니다.");
	}

	private void reserve(Ticket t) {
		System.out.println("Call Real reserve method");
		reservationRepository.save(t);
	}


}
