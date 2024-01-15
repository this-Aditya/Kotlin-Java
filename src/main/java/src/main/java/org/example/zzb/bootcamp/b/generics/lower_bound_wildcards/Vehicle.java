package org.example.zzb.bootcamp.b.generics.lower_bound_wildcards;

public abstract class Vehicle {
    private int wheels;
    private int seats;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Vehicle(int wheels, int seats) {
        this.wheels = wheels;
        this.seats = seats;
    }
}
