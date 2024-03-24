package com.example.ch02;

import org.junit.jupiter.api.*;

public class JunitProcessTest {

	public JunitProcessTest() {
		System.out.println("JunitProcessTest 생성자 호출");
	}


	@BeforeAll
	public static void beforeAll() {
		System.out.println("beforeAll 호출");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEach 호출");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("afterAll 호출");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("afterEach 호출");
	}

	@Test
	@DisplayName("샘플 테스트")
	public void test() {
		System.out.println("test 호출");
	}


}
