package com.musinsa.util.study.ch02;

import java.math.BigInteger;

public class Study03 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new SampleThread(new BigInteger("10000000000000000000000")));

        t.setDaemon(true);
        t.start();
        t.join(2000);

    }

    public static class SampleThread extends Thread {

        private BigInteger total = BigInteger.ZERO;
        private BigInteger max;

        public SampleThread(BigInteger max) {
            this.max = max;
        }

        @Override
        public void run() {
            BigInteger i = BigInteger.ZERO;
            while (i.compareTo(max) < 0) {
                total = total.add(i);
                i = i.add(BigInteger.ONE);
            }
        }

    }

}
