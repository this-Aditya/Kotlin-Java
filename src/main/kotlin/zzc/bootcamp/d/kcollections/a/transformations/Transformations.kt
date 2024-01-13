package zzc.bootcamp.d.kcollections.a.transformations

import zzc.bootcamp.d.kcollections.Country
import zzc.bootcamp.d.kcollections.countries

fun main() {
//map()
//mapIndexed()
//    mapNotNull()
//    mapIndexedNotNull()
//zip()
//    associateWith()
//    associateBy()
    associate()

}



// 1. Map


fun map() {

//      val continents = countries.map { it.continent }
//      Another way
//      val continents = countries.map(::continentMapping)
//      One more way!!
    val continentMapping: (Country) -> String = { country ->
        country.continent
    }
    val continents = countries.map(continentMapping)

    val strings = listOf("one", "two"," three", "four")
    val mapped = strings.map(String::length)

    println(continents)
}

fun continentMapping(country: Country): String = country.continent


// 2. MapIndexed!!

fun mapIndexed() {

//        val continentsIndexed = countries.mapIndexed { index, value ->
//            "$index: ${value.continent}"
//        }

//        val continentsIndexed = countries.mapIndexed(::continentIndexed)

    val continentsIndex: (Int, Country) -> String = { index, value ->
        "$index: ${value.continent}"
    }

    val continentsIndexed = countries.mapIndexed(continentsIndex)

    println(continentsIndexed)
}

fun continentIndexed(index: Int, value: Country) = "$index: ${value.continent}"


// 3. MapNotNull

fun mapNotNull() {
    val asians = countries.mapNotNull { country ->
        if (country.continent != "Asia") null else country.name
    }

    println(asians)

}

// 4. MapIndexedNotNull

fun mapIndexedNotNull() {

    val indexMap: (Int, Country) -> String? = { index, country ->
        if (countries[index].continent != "Asia") null else countries[index].name
    }

    val asians = countries.mapIndexedNotNull(indexMap)
    println(asians)
}


// Zip

fun zip() {
    val animals = listOf("lion", "elephant", "dog")
    val colors = listOf("yellow", "grey", "black")
    val pair = animals zip colors
//        println(pair)
//      [(lion, yellow), (elephant, grey), (dog, black)]

//        val more = listOf("power", "size")
//        val newPair = pair zip more
//        println(newPair)
//        [((lion, yellow), power), ((elephant, grey), size)]
}


// AssociateWith !!

fun associateWith() {
    var count = 0
    val nums = listOf("one", "two", "three", "four", "two", "five")
    val association = nums.associateWith { count++ }
    println(association)
//        {one=0, two=4, three=2, four=3, five=5}
}

// AssociateBy

    fun associateBy() {
        val nums = listOf("one", "two", "three", "four", "five")
//        val association = nums.associateBy { it.first().uppercaseChar() }
//        println(association)
//        {O=one, T=three, F=five}

        val newAssociation = countries.associateBy(
            keySelector = { it.name },
            valueTransform = { it.continent }
        )
        println(newAssociation)
    }

// Associate!!

    fun associate() {
        val names = listOf("Abhay Agarwal", "Aditi Jangid", "Aditya Mishra", "Alok Meena", "Aman Agarwal")
//        val associatedNames = names.associate(
//            transform = {name ->
//                parseFullName(name)
//            }
//        )
//        println(associatedNames)
//        {Abhay=Agarwal, Aditi=Jangid, Aditya=Mishra, Alok=Meena, Aman=Agarwal}

//     Other way
        val moreAssociations = names.associate { name->
            parseFullName(name)
        }
        println(moreAssociations)
    }

    fun parseFullName(fullName: String): Pair<String?, String?> {
        val dividedName = fullName.split(" ")
        if (dividedName.size == 2) {
            return Pair(dividedName.get(0), dividedName.get(1))
        }
        return Pair(null, null)
    }



















































































































