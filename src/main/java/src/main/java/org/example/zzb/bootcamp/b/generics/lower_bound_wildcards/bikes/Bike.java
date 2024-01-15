package org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.bikes;

import org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.Vehicle;

abstract public class Bike extends Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bike(String name) {
        super(4, 1);
        this.name = name;
    }



}
