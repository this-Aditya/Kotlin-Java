package a.test.a.hash_check

import java.util.Objects

class Two {
    var id = 8765432
    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}
fun main() {
    val one = One().hashCode()
    val two = Two().hashCode()
    println(one == two)
}