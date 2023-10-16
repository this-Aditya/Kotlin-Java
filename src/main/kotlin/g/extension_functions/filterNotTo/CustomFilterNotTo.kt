package g.extension_functions.filterNotTo

inline fun <Bike, C : MutableCollection<Bike>> Iterable<Bike>.customFilterNotTo(
    destination: C,
    predicate: (Bike.() -> Boolean)
): C {
    forEach {
        if (!predicate(it)) {
            destination.add(it)
        }
    }
    return destination
}
