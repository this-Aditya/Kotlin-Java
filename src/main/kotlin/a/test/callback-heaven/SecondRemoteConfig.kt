package a.test.`callback-heaven`

import a.test.`callback-heaven`.MainConfiguration.MainConfigStatus.INITIAL

class SecondRemoteConfig : RemoteConfig {

    override var status: MainConfiguration.MainConfigStatus = INITIAL
        set(value) {
            println("SECOND-CONFIG: status updated to $value")
            field = value
            onStatusUpdateListener(value)
        }

    override var onStatusUpdateListener: (MainConfiguration.MainConfigStatus) -> Unit =
        {
            /**
             * Again dummy work :)
             */
        }
}