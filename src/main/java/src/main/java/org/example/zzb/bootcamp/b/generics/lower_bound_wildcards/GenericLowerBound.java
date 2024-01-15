package org.example.zzb.bootcamp.b.generics.lower_bound_wildcards;


import org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.bikes.Bike;
import org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.bikes.Classic350;
import org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.cars.Car;
import org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.cars.MaybachGLS;
import org.example.zzb.bootcamp.b.generics.lower_bound_wildcards.cars.Velar;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Wildcards Bound are Based on the simple concept:
 *  PECS -> Producer Extends and Consumer Super
 *  The producer and consumer are pointing to the generic class...
 */
public class GenericLowerBound {

    public static void main(String[] args) {
        Bike reChromeBronze = new Classic350("Chrome Bronze");
        Car rrVelar = new Velar("White");
        Car maybach = new MaybachGLS("Night Series");
    // For using a lower bound just make a generic list

        List<Car> cars = new ArrayList<>();
//      cars.add(reChromeBronze); // Can't add, required type: Car, provided: Bike
        cars.add(rrVelar);
        doAddCar(cars, maybach);
    }

    private static void doAddCar(List<? super Car> cars, Car car ) {
        cars.add(car); // We can't do the Maybach data type here!!
    }
}
