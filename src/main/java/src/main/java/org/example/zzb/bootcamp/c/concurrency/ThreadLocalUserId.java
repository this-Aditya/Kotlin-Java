package org.example.zzb.bootcamp.c.concurrency;

public class ThreadLocalUserId {
    ThreadLocal<String> threadName = new ThreadLocal<>();

    class NumericRunnable implements Runnable {
        @Override
        public void run() {
            threadName.set(Thread.currentThread().getName());
            System.out.println("Thread "+ Thread.currentThread().getName()+" entered!!");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String name = threadName.get();
            System.out.println("name is: "+ name);
        }
    }

    public static void main(String[] args) {
        ThreadLocalUserId th = new ThreadLocalUserId();
        ThreadLocalUserId.NumericRunnable rb = th.new NumericRunnable();

        Thread first = new Thread(rb, "first");
        Thread second = new Thread(rb, "second");
        first.start();
        second.start();
    }
}

class Main {
    public static void main(String[] args) {

    }
}
