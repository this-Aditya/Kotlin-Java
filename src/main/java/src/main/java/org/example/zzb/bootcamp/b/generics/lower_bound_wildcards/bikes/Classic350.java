package org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.bikes;

public class Classic350 extends Bike{
    public Classic350(String color) {
        super("Royal Enfield: Classic 350 Chrome Bronze");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;
}
