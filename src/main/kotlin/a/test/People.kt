package a.test


class People internal constructor(var name: String?, var age: Int) {
    override fun equals(obj: Any?): Boolean {
        if (this === obj) {
            return true
        }
        if (obj == null || javaClass != obj.javaClass) {
            return false
        }
        val people = obj as People
        return age == people.age && name == people.name
    }

        fun main(args: Array<String>) {
            val one = People(null, 21)
            val two = People(null, 21)
            println(one == two)
        }
    }

