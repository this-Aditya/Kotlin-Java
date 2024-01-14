package org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo;

import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Eats;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Sleeps;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Swims;

public class Shark extends Animal implements Eats, Sleeps, Swims {

    String name = "Shark";

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void swim() {

    }
}
