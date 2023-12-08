package org.example.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Inconsistencies {

     AtomicInteger counter = new AtomicInteger();

    void increase() {
        for (int i = 0; i < 100000; i++) {
            counter.getAndIncrement();
//        System.out.println("Increased, new value: "+ counter);
        }
    }

    void decrease() {
        counter.getAndDecrement();
    }
    void value() {
        System.out.println("Value is "+ counter);
    }
}

class Work {
    public static void main(String[] args) {
        Inconsistencies ic = new Inconsistencies();
        Thread one = new Thread(ic::increase);
        Thread two = new Thread(ic::value);
        new Thread(one::start).start();
        two.start();
    }
}
