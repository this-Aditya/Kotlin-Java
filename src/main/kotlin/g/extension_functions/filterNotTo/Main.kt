package g.extension_functions.filterNotTo

data class Bike(val name: String, val color: String, val engine: Int)

fun bikeFilter() {
    val bikes = listOf (
        Bike("Royal Enfield", "Chrome Bronze", 350),
        Bike("CB-Twister", "Red Black", 200),
        Bike("Splendor", "Blue Black", 150),
        Bike("Royal Enfield", "Interceptor", 650),
        Bike("Royal Enfield", "Meteor", 600)
    )

    val effectiveBikes: MutableList<Bike> = mutableListOf()

    bikes.customFilterNotTo(effectiveBikes) { engine > 400 }

    println(effectiveBikes)

}


fun main() {
    bikeFilter()
}