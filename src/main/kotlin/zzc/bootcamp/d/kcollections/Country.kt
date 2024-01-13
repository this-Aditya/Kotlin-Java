package zzc.bootcamp.d.kcollections


data class Country(val name: String, val continent: String) {

    override fun toString(): String {
        return ("Country: $name :: Continent: $continent")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        return (other as Country).let { o ->
            this@Country.name == o.name
                    && this@Country.continent == o.continent
        }
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + continent.hashCode()
        return result
    }
}

 val countries = listOf(
    Country("India", "Asia"),
    Country("United Kingdom", "Europe"),
    Country("France", "Europe"),
    Country("Seattle", "North America"),
    Country("Los Angeles", "North America"),
    Country("Japan", "Asia"),
    Country("UAE", "Asia"),
    Country("Singapore", "Asia"),
    Country("Germany", "Europe"),
)

