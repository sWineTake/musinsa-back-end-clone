package com.example.testcode.ch04.repository;

import java.util.HashMap;
import java.util.Map;

public class StubGradeRepository {

	public Map<String, Integer> findByName(String name) {
		Map<String, Integer> result = new HashMap<>();
		result.put("OOP", 8);
		result.put("FP", 6);
		result.put("DB", 9);

		return result;
	}

}
