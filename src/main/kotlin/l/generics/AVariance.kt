package l.generics

import java.util.LinkedList

class AVariance {
}

fun testVariance() {
    val strs: List<String> = ArrayList()
    val objs: List<Any> = strs

    val nums: MutableList<Number> = mutableListOf(1,2.0,3,4L,675865)
    val x = nums.get(1) as Int
    nums.add(4635)
    nums.clear()

}