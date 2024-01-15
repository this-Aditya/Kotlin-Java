package org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.cars;

import org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.Vehicle;

abstract public class Car extends Vehicle {

    String name;
    public Car(String name) {
        super(4, 5);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
