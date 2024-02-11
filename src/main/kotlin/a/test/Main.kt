package a.test

import java.util.HashSet

    fun main() {
        val paired: MutableSet<Device> = HashSet()
        paired.add(Device("Realme Buds", true))
        paired.add(Device("Ford", true))
        paired.add(Device("Zebronics", true))
        val newelyPaired: MutableSet<Device> = HashSet()
        newelyPaired.add(Device("Realme Buds", true))
        newelyPaired.add(Device("Zebronics", true))
//        newelyPaired.add(Device("Ford", true))
        newelyPaired.add(Device("Xi Tang", true))

        val devicesToUpdate = newelyPaired.subtract(paired)
        println(devicesToUpdate)
        paired.subtract(newelyPaired).apply(::println)
    }

data class Device(var name: String, var isPaired: Boolean)
