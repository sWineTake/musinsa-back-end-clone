package com.example.testcode.ch04.service;

import com.example.testcode.ch04.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PerformanceService {

	private final PerformanceRepository performanceRepository;

	public String isEnableReserve(UUID performanceId) {
		System.out.println("Execute perduce method");
		return performanceRepository.findById(performanceId).orElseThrow().getIsReserve();
	}
}
