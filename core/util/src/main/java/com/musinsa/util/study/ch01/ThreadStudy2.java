package com.musinsa.util.study.ch01;

import java.util.Random;

public class ThreadStudy2 {


	public static void main(String[] args) {

		Random r = new Random();
		int value = r.nextInt(300);

		Valut v = new Valut(value);

		Thread thread = new AcsHackerThread(v);

		thread.start();
	}

	private static class Valut {
		private int password;
		public Valut(int password) {
			this.password = password;
		}

		public boolean isCorrectPassword(int password) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return this.password == password;
		}
	}
	private static abstract class HackerThread extends Thread {
		protected Valut valut;

		public HackerThread(Valut valut) {
			this.valut = valut;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);// 우선순위 최대
		}

		/*@Override
		public void start() {
			System.out.println("Starting thread : " + this.getName());
			super.start();
		}*/
	}
	private static class AcsHackerThread extends HackerThread {

		public AcsHackerThread(Valut valut) {
			super(valut);
		}

		@Override
		public void run() {
			String name = this.getName();
			System.out.println(name);
			for (int i = 0; i < 300; i++) {
				if (valut.isCorrectPassword(i)) {
					System.out.println(this.getName() + " cracked password : " + i);
					System.exit(0);
				}
			}
		}

	}
	private static class DescHackerThread extends HackerThread {

		public DescHackerThread(Valut valut) {
			super(valut);
		}

		@Override
		public void run() {
			for (int i = 9999; i >= 0; i--) {
				if (valut.isCorrectPassword(i)) {
					System.out.println(this.getName() + " cracked password : " + i);
					System.exit(0);
				}
			}
		}

	}

}
