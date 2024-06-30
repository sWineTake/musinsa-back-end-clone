package com.musinsa.util.study.ch01;

public class test {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm going for a walk");
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm going to swim");
			}
		});

		thread1.start();
		thread2.start();
		System.out.println("I'm going home");
	}
}
