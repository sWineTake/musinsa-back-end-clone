package com.example.testcode.ch04.repository;

import com.example.testcode.ch04.domain.dto.Performance;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PerformanceRepository {
	Optional<Performance> findById(UUID performanceId);
}
