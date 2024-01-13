package zzc.bootcamp.d.kcollections.c.plus_minus

import zzc.bootcamp.d.kcollections.Country
import zzc.bootcamp.d.kcollections.countries

fun main() {
plusMinus()
}



fun plusMinus() {
 val newCountries = countries - listOf( Country("India", "Asia"))
    newCountries.forEach (::println)
}









