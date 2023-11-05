package l.generics

interface AConsumer<in T> {
    fun consumeT(t: T)
//    fun produceT(t: Int): T  Error: Type parameter T is declared as 'in' but occurs in 'out' position in type T
    fun performWork(v: Int): String

}

private fun demo() {
    val consumer = object : AConsumer<Number> {
        override fun consumeT(t: Number) {
            println("Consumed $t")
        }

        override fun performWork(v: Int): String {
            println("Performed Work on: $v")
        return "Performed on: $v"
        }
    }

    consumer.consumeT(7628.7856) // @param can be Number or any subtype of number
    consumer.performWork(767)


}