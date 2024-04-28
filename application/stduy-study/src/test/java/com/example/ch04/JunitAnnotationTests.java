package com.example.ch04;

import com.example.stduy.ch04.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class JunitAnnotationTests {

	/*
		@Test
		void 유저의_이름이_NULL_예외처리가_되어야한다() {
			Assertions.assertThatThrownBy(() -> {
				new User(null);
			}).isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		void USER_이름은_공백이면_예외처리가_되어야_한다() {
			Assertions.assertThatThrownBy(() -> {
				new User("");
			}).isInstanceOf(IllegalArgumentException.class);
		}
	*/

	/*
	 * 위 2개의 USER 이름처리 에러같은경우, new User("") 이거나 new User(null) 이 2개의 차이가 있다.
	 * 이때 ParameterizedTest를 통해 두개의 테스트를 한번에 처리할 수 있다.
	 * ValueSource 어노테이션을 통해 기본값 "" , " " 2개와
	 * NullAndEmptySource 어노테이션을 통해 null, "" 2개 총합 4개에 테스트를 한번에 진행할 수 있다.
	*/
	@ParameterizedTest
	@ValueSource(strings = {"", " "})
	@NullAndEmptySource
	void USER_NAME_VALIDATION_테스트(String name) {
		Assertions.assertThatThrownBy(() -> {
			new User(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * CsvSource 어노테이션을 통해 2개의 파라미터를 받아서 테스트를 진행할 수 있다.
	*/
	@ParameterizedTest
	@CsvSource(value = {"1, 2", "2, 4", "3, 6"})
	// @CsvSource(value = {"1|2", "2|4", "3|6"}, delimiter = '|') 구분자를 지정도 가능하다
	void csvSourceTest(int input, int expected) {
		Assertions.assertThat(input * 2).isEqualTo(expected);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * RepeatedTest 어노테이션을 통해 반복테스트를 진행할 수 있다.
	 * 파라미터 변수를 통해 1부터 값을 얻을수있다.
	*/
	@RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
	void repeatedTest(RepetitionInfo info) {
		int curretRepetition = info.getCurrentRepetition();
		System.out.println("curretRepetition = " + curretRepetition);
		assertEquals(curretRepetition, curretRepetition );
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@TestFactory
	List<DynamicNode> testFactory() {
		List<DynamicNode> result = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			// DB에서 데이터를 가져와서 결정하거나, External API값을 가져와서 설정할수 있다.
			int finalI = i;
			result.add(
				dynamicTest("test casename : " + finalI,
					// 테스트가 실제로 이루어지는 코드
					() -> System.out.println("i = #" + finalI))
			);
		}

		return result;
	}

}
