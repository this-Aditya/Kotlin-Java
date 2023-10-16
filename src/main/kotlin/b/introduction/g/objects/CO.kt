package b.introduction.g.objects

class CO {
    companion object {
        fun create(): CO = CO()
    }
}

fun main() {
    val instance = CO.create()
    val instance2 = CO.Companion
    val instance3 = CO
    println(instance)
    println(instance2)
    println(instance3)

}