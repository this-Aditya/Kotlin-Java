package org.example.zzz.utils;

import java.util.concurrent.ThreadLocalRandom;

public class TLRTest {
    public static void main(String[] args) {
        TLR tlr = new TLR();
        Thread one = new Thread(tlr);
        Thread two = new Thread(tlr);
        Thread three = new Thread(tlr);
        Thread four = new Thread(tlr);
        Thread five = new Thread(tlr);
        Thread six = new Thread(tlr);
        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        six.start();
    }
}

class TLR implements Runnable {
    @Override
    public void run() {
        System.out.println("Run: Thread: "+ Thread.currentThread().getName());
        ThreadLocalRandom random = ThreadLocalRandom.current();
//        Random random = new Random();
        int randomNumber = random.nextInt();
        System.out.println("Thread: " + Thread.currentThread().getName() + ", Random: "+ random);
    }
}



