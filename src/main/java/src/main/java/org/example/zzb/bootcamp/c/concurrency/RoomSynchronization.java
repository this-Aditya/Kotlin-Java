package org.example.zzb.bootcamp.c.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoomSynchronization {
    int counter;
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        SyncRunnable srun = new SyncRunnable(lock);
        SyncRunnable srun2 = new SyncRunnable(lock);

        Thread one = new Thread(srun, "one");
        Thread two = new Thread(srun2, "two");
        one.start();
        two.start();
    }
}

class SyncRunnable implements Runnable {

    final Lock lock;

    SyncRunnable(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " started working for " + i + "th time");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " completed work  for " + i + "th time");
            }
        }
    }
}