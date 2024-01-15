package org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.cars;

public class Velar extends Car{

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    public Velar(String color) {
        super("Land Rover Range Rover Velar");
        this.color = color;
    }

}
