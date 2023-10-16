package g.extension_functions.filterTo

inline fun <Person, C: MutableCollection<Person>> Iterable<Person>.customFilterTo(
    destination: C,
    predicate: (Person) -> Boolean
): C {
    forEach {
       if (predicate(it)) destination.add(it)
    }
    return destination
}