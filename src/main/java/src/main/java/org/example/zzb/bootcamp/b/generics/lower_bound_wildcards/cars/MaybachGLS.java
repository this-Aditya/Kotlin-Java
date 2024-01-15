package org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.cars;

public class MaybachGLS extends Car{

    String color;
    public MaybachGLS(String color) {
        super("Mercedes Maybach GLS Night Series");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
