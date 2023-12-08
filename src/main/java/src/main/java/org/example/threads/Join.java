package org.example.threads;

public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new JoinThread();
        myThread.start();
        System.out.println("Before join!! ");
        myThread.join();
        System.out.println("After join!!");
    }
}

class JoinThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception occured!!");
        }
    }



}
