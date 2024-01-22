package org.example.zzb.bootcamp.c.concurrency;

public class LockSynchronized {
    static BikeManufacturer bm = new BikeManufacturer();

    public static void main(String[] args) {
        new Thread(() -> bm.addEngine(), "engineThread").start();
        new Thread(() -> bm.addSeat(), "seatThread").start();
        new Thread(() -> bm.addTyres(), "tyreThread").start();
    }
}

class BikeManufacturer {
    synchronized void addTyres() {
            System.out.println("Adding tyres to bike");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Added tyres to bike");
        }

    synchronized void addSeat() {
            System.out.println("Adding seat to bike");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Added seat to bike");
        }

    synchronized void addEngine() {
            System.out.println("Adding engine to bike");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Added engine to bike");
        }
    }
