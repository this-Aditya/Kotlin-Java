package org.example.zzb.bootcamp.c.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// The case that is happening, we don;t want this, point-- this can be rectified just by using same lock for
// all synchronized blocks.
// currently both the threads can call functions at the same time
public class MutexRaceConditions {
//    static MutexCorrectedRoutine rt = new MutexCorrectedRoutine(); // this will provide consistent results
    static MutexRaceRoutine rt = new MutexRaceRoutine();

    public static void main(String[] args) {
        Thread first = new Thread(() -> {
           rt.wakeUp();
           rt.workout();
           rt.takeShower();
        }, "first");
        Thread second = new Thread(() -> {
            rt.wakeUp();
            rt.workout();
            rt.takeShower();
        }, "second");
        first.start();
        second.start();
    }
}


class MutexRaceRoutine {
    final Lock first = new ReentrantLock();
    final Lock second = new ReentrantLock();
    final Lock third = new ReentrantLock();
    void wakeUp() {
        synchronized (first) {
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--Waking up");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--Waked up");
        }
    }

    void workout() {
        synchronized (second) {
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--working out");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--worked out");
        }
    }

    void takeShower() {
        synchronized (third) {
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--taking shower");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--took shower");
        }
    }
}


class MutexCorrectedRoutine {
    final Lock first = new ReentrantLock();
    final Lock second = new ReentrantLock();
    final Lock third = new ReentrantLock();
    void wakeUp() {
        synchronized (this) {
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--Waking up");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--Waked up");
//            workout();
        }
    }

    void workout() {
        synchronized (this) {
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--working out");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--worked out");
//            takeShower();
        }
    }

    void takeShower() {
        synchronized (this) {
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--taking shower");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread: "+ Thread.currentThread().getName() +"--took shower");
        }
    }
}