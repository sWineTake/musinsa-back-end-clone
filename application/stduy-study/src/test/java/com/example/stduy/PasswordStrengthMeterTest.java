package com.example.stduy;

import com.example.stduy.ch01.PasswordStrength;
import com.example.stduy.ch01.PasswordStrengthMeter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

	@Test
	@DisplayName("패스워드 - 3가지 충족이 되는경우")
	void meetsAllCriteria_Then_Strong() {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();
		PasswordStrength result = meter.meter("ab12!@ABC"); // 기대 값 : STRONG
		assertEquals(PasswordStrength.STRONG, result);
	}

	@Test
	@DisplayName("패스워드 - 2가지 충족이 되는 경우")
	void test1() {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();
		PasswordStrength result = meter.meter("ab12!@"); // 기대 값 : STRONG
		assertEquals(PasswordStrength.NORMAL, result);
	}



}
