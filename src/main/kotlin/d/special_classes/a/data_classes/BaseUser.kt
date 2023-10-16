package d.special_classes.a.data_classes

data class BaseUser(val name: String, val id: Int) {
    override fun equals(other: Any?): Boolean = (other is BaseUser) && (this.id == other.id)
}

fun main() {
    val user = BaseUser("Alex", 1)
//    println(user)
    val secondUser = BaseUser("Alex",1)
    val thirdUser = BaseUser("Jackal", 2)
//    println(user == secondUser)
//    println(user == thirdUser)
    // hashcode
    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    // copy fucntion

//    println(user.copy().hashCode())
    println(user === user.copy())
    println(user.copy("Max"))
    println(user.copy(id = 4))
    println("Name: ${user.component1()}")
}