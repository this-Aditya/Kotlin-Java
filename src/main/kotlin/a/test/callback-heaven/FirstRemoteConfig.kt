package a.test.`callback-heaven`

import a.test.`callback-heaven`.MainConfiguration.MainConfigStatus.*

class FirstRemoteConfig : RemoteConfig {

    override var status: MainConfiguration.MainConfigStatus = INITIAL
        set(value) {
            println("FIRST-CONFIG: status updated to $value")
            field = value
            onStatusUpdateListener(value)
        }



    override var onStatusUpdateListener: (MainConfiguration.MainConfigStatus) -> Unit =
        {
            println("CALLBACK(FIRST-CONFIG): New Status is: $it")
        }
}

fun main() {
    val first = FirstRemoteConfig()
    val second = SecondRemoteConfig()
    val both = CombinedConfigs(listOf(first, second))

    first.status = FETCHING
    second.status = PARTIALLY_FETCHED
    first.status = UNAVAILABLE
    second.status = FETCHED
}