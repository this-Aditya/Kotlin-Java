package org.example.threads;

class Interrupt {
    public static void main(String[] args) {
        Thread newThread = new SecondThread();
        newThread.start();
        newThread.interrupt();
    }
}


class SecondThread extends Thread {

    @Override
    public void run() {
        super.run();
        if (Thread.interrupted()) {
            System.out.println("Second Thread is interrupted.");
        }
        System.out.println("Interrupted status: "+ Thread.interrupted());
    }
}