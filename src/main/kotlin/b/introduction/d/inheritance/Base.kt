package b.introduction.d.inheritance

abstract class Base : Intf {

    val first = "first"

     override fun onCreate() {
        println("On Create of Base class!!")
        setUpLogging()
    }

     override fun setUpLogging() {
        println("Setting up logging in base class!!")
    }

}