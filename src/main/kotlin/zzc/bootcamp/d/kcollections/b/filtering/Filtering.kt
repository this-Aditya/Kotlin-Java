package zzc.bootcamp.d.kcollections.b.filtering

import zzc.bootcamp.d.kcollections.countries

fun main() {
//filterList()
//filterMap()
//filterIsInstance()
    filterNotNull()
}




// Filter

fun filterList() {
    val asians = countries.filterNot { country ->
        country.continent != "Asia"
    }
    println(asians)
}

fun filterMap() {
    val countryMap = countries.map { Pair(it.name, it.continent) }.toMap()
    val asians = countryMap.filter { it.value == "Asia" }
    println(asians)
}


//  FilterIsInstance

fun filterIsInstance() {
    val anys = listOf(countries, "one", 1, null, "five", 5.6, "seven", "nine")
    val stringList = anys.filterIsInstance<String>()
    println(stringList)
}


// FilterNotNull

fun filterNotNull() {
    val anys = listOf("one", null, "five", "seven")
    val nonNulls = anys.filterNotNull()
    println(nonNulls)

}




