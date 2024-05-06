package com.musinsa.util.study.ch02;

import java.math.BigInteger;

public class ThreadStudy01 {

	public static void main(String[] args) {

		/*Thread t = new Thread(new InterruptThread());

		// main 메소드가 죽으면, 해당 연결된 쓰레드를 모두 죽임
		// t.setDaemon(true);
		t.start();
		t.interrupt();*/

		Thread t = new Thread(new InterruptThread2());
		t.start();
		t.interrupt();
	}

	// 기본적인 인터럽트 예제
	private static class InterruptThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(5000000);
			} catch (Exception e) {
				System.out.println("인터럽트 발생");
			}
		}
	}

	// 상위 인터럽트 예제
	private static class InterruptThread2 extends Thread {
		BigInteger value = BigInteger.ZERO;
		@Override
		public void run() {
			value = pow(new BigInteger("2"), new BigInteger("1000000"));
		}
		private BigInteger pow(BigInteger value, BigInteger power) {
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("인터럽트 발생");
					return BigInteger.ZERO;
				}
				value = value.multiply(value);
			}
			return value;
		}

	}

}
