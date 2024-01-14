package org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo;

import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Eats;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Runs;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Sleeps;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Swims;

public class Ant implements Runs, Eats, Sleeps, Swims {
    String name = "Ant";

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void swim() {

    }
}
