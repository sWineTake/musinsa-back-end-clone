package com.example.testcode.ch04.repository;

import com.example.testcode.ch04.domain.dto.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository {

	void save(Ticket t);
}
