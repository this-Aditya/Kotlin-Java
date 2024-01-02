package zzc.bootcamp.b.classes_and_objects.a.delegates

import kotlin.properties.Delegates
import kotlin.reflect.KProperty


fun main() {
    val exp = Example()
    exp.user = "one"
    exp.user = "two"

}

class Base {
}

class Example {
    var p: String by Delegate()
    var user: String by Delegates.observable("<no value>") { prop, old, new ->
        println("Property-> $prop, old_value -> $old, new_value -> $new")
    }
}


class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}