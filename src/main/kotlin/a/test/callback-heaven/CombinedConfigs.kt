package a.test.`callback-heaven`

class CombinedConfigs
    (val remoteConfigs: List<RemoteConfig>)
{

        init {
            remoteConfigs.forEach {
                it.onStatusUpdateListener = { newStatus ->
                    println("Callback(COMBINED-CONFIG): New status is $newStatus")
                }
            }
        }

}