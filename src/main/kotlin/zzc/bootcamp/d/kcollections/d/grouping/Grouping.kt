package zzc.bootcamp.d.kcollections.d.grouping

import zzc.bootcamp.d.kcollections.countries

fun main() {
groupBy()
}

// GroupBy

fun groupBy() {
    val groupedCountries = countries.groupBy { it.continent }
    groupedCountries.forEach{ (continent, country) ->
        println("$continent: ${country.joinToString (
            transform = { it.name },
            separator = " - "
        )}")
    }
}