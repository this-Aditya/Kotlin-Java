package b.introduction.d.inheritance

class Derived : Base(){

    override fun onCreate() {
        println("On Create of derived class!!")
        super.onCreate()
    }

    override fun setUpLogging() {
        println("Setting up Logging in derived class!!")
    }

}

fun main() {
    Derived().onCreate()
}