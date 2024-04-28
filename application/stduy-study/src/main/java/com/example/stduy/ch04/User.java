package com.example.stduy.ch04;

public class User {

	private final String name;

	public User(String name) {
		validationName(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void validationName(String name) {
		validateNotNull(name);
		validateNameLength(name);
	}

	private void validateNotNull(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("이름은 필수값입니다.");
		}
	}

	private void validateNameLength(String name) {
		if (name.length() < 1 || name.length() > 10) {
			throw new IllegalArgumentException("이름은 1자 이상 10자 이하로 입력해주세요.");
		}
	}
}
