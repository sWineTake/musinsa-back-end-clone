package com.musinsa.util.study.ch01;

public class ThreadStudy {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			System.out.println("Hello Thread : " + Thread.currentThread().getName());

			throw new RuntimeException("sample error");

		});

		thread.setName("MyThread");
		thread.setUncaughtExceptionHandler((t, e) -> {
			System.out.println("UncaughtExceptionHandler : " + t.getName() + " -> " + e.getMessage());
		});

		System.out.println("Hello : " + Thread.currentThread().getName());
		thread.start();
		System.out.println("Bye : " + Thread.currentThread().getName());

	}
}
