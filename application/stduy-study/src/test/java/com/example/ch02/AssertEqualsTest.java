package com.example.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertEqualsTest {

	@Test
	@DisplayName("입력값과 비교값이 같은 값인지 비교하는 테스트")
	public void assertEqualsExampleTest() {
		int x = 1;
		int y = 1;
		assertEquals(x, y);
	}

	@Test
	@DisplayName("NP시 발생하는 예외 테스트")
	public void nullPointExceptionTest() {

		try {
			toUpperCase(null);
			fail(); // 코드의 흐름으로 이곳에 오면 에러처리 진행
		} catch (NullPointerException e) {

		}
	}

	private String toUpperCase(String str) {
		if (str == null) throw new NullPointerException();
		return str.toUpperCase();
	}

	@Test
	@DisplayName("메소드 호출시 에러 핸들링")
	public void toUpperCaseThrowNullPointException() {
		assertThrows(NullPointerException.class, () -> toUpperCase(null));
	}

}
