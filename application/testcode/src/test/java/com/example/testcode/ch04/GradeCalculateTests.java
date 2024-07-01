package com.example.testcode.ch04;

import com.example.testcode.ch04.domain.dto.test_doubles.Student;
import com.example.testcode.ch04.repository.StubGradeRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeCalculateTests {

	private StubGradeRepository stubGradeRepository = new StubGradeRepository();

	private Map<String, Integer> grades(Student s) {
		return stubGradeRepository.findByName(s.getName());
	}

	@Test
	void avgGradesTest() {
		Student student = Student.builder()
				.name("Kim")
				.avgGrade(0)
				.grade(new HashMap<>())
				.sex('M')
				.phoneNumber("010-1234-5678")
				.build()
			;

		Map<String, Integer> result = grades(student);
		int total = 0;
		int expected = 7;
		for (String grade : result.keySet()) {
			total += result.get(grade);
		}

		assertEquals(expected, total / result.size());
	}

}
