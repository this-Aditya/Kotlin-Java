package a.test.`callback-heaven`

interface RemoteConfig {
    val status: MainConfiguration.MainConfigStatus
    var onStatusUpdateListener: (MainConfiguration.MainConfigStatus) -> Unit
}