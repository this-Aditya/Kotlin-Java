package b.introduction.e.classes


class Bike(val name: String, company: String, engine: Int) {
    init {
        println("Creating bike with company: $company")
    }
    constructor(naam: String, compani: String, dum: Int, pesa: Int): this(naam, compani, pesa) {
        println("Bike's price is $pesa")
    }
    val x = company
    val y = engine
}

fun bikeInfo(bike: Bike) {
    println("name: ${bike.name}\ncompany: ${bike.x}\nengine: ${bike.y}")
}


fun main() {
    Bike("Classic 350", "Royal Enfield", 350).also (::bikeInfo)
    Bike("Classic 350", "Royal Enfield", 350, 275000).also (::bikeInfo)
}