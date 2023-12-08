package org.example.threads;

class MyThread extends Thread {
    public void run() {
        try {
            // Some time-consuming task
            for (int i = 0; i < 100000; i++) {
                // Check for interruption
//                if (Thread.interrupted()) {
//                    System.out.println("Thread interrupted. Exiting gracefully.");
//                    return;
//                }
                Thread.sleep(1000);

                // Simulate some work
                double x = Math.hypot(Math.pow(Math.random(), i), Math.pow(Math.random(), i));
                System.out.println("Result is "+ x);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred "+ e.getMessage());
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
//        try {
            Thread.sleep(1200);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // Some time later, interrupt the thread
        myThread.interrupt();
    }
}

