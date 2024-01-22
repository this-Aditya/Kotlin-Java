package org.example.zzb.bootcamp.c.concurrency;

class DeadlockExample {
    final String resource1 = "Resource1";
    final String resource2 = "Resource2";

    public void method1() {
        synchronized (resource1) {
            System.out.println("Thread 1: Holding lock on Resource1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (resource2) {
                System.out.println("Thread 1: Holding lock on Resource1 and Resource2");
            }
        }
    }

    public void method2() {
        synchronized (resource2) {
            System.out.println("Thread 2: Holding lock on Resource2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (resource1) {
                System.out.println("Thread 2: Holding lock on Resource2 and waiting for Resource1");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();

        // Thread 1
        new Thread(deadlockExample::method1).start();

        // Thread 2
        new Thread(deadlockExample::method2).start();
    }
}
