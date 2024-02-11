package org.example.zzb.bootcamp.a.collections.queue;

import java.util.PriorityQueue;

public class QueueExample {

    public static void main(String[] args) {
        PriorityQueue<Bike> bikes = new PriorityQueue<>((o1, o2) -> o1.enginePower - o2.enginePower);
        bikes.offer(new Bike("Royal Enfield", "Classic 350", 350));
        bikes.offer(new Bike("Hero Honda", "Passion Plus", 110));
        bikes.offer(new Bike("Honda", "CB Twister", 180));
        bikes.offer(new Bike("Royal Enfield", "Continental", 650));
        bikes.offer(new Bike("Honda", "Activa", 120));

        System.out.println(bikes);
    }
}

class Bike
//        implements Comparable<Bike>
{
    String name;
    String company;
    int enginePower;

    public Bike(String company, String name, int enginePower) {
        this.name = name;
        this.company = company;
        this.enginePower = enginePower;
    }

//    @Override
//    public int compareTo(Bike o) {
//        return Integer.compare(enginePower, o.enginePower);
//    }

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", enginePower=" + enginePower +
                '}';
    }
}
