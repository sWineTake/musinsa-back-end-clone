package com.example.testcode.ch04.domain.dto.test_doubles;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private String name;
	private int avgGrade;
	private Map<String, Integer> grade;
	private char sex;
	private String phoneNumber;

}
