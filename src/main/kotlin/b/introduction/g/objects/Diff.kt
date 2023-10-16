package b.introduction.g.objects

class Diff {
    val a = 7
    object obj {
        init {
            println("Object initialized")
        }
        var x = 0
        fun doWork() {
            x++
            println(x)
        }
    }
    companion object {
        init {
            println("Companion object initialized")
        }
    }
}

fun main() {
    val one = Diff()
    val two = Diff()
    val three = Diff()
    Diff.obj.apply {
        doWork()
        doWork()
        doWork()
    }
}