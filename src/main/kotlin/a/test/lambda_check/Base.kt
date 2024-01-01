package a.test.lambda_check


fun main() {
    enterCredentials()
}

val authConnection = AuthConnection()
val appAuthState = AppAuthState()

fun enterCredentials() {
    println("METHOD: enterCredentials()")
    applyMpManager{_,manager, state->
        println("Manager -> $manager, State -> $state")
    }
}

fun applyMpManager(callback: (AuthService.AuthServiceBinder, ManagementPortalLoginManager, AppAuthState) -> Unit) {
    println("METHOD: applyMpManager()")
    authConnection.applyBinder {
        val manager = ManagementPortalLoginManager()
        applyState {
            callback(this@applyBinder, manager, this)
        }
    }
}


class AuthConnection {
private val binder = AuthService().AuthServiceBinder()
    fun applyBinder(callback: AuthService.AuthServiceBinder.() -> Unit) {
        println("AuthConnection METHOD: applyBinder()")
        binder.apply(callback)
    }
}

class AuthService {

    fun applyState(function: AppAuthState.() -> Unit) {
        println("AuthService METHOD: applyState()")
        appAuthState.apply(function)
    }

    inner class AuthServiceBinder {
        fun applyState(apply: AppAuthState.() -> Unit) {
            println("AuthServiceBinder METHOD: applyState()")
            this@AuthService.applyState(apply)
        }
    }

}

class ManagementPortalLoginManager {
    override fun toString(): String {
        return "CLASS: ManagementPortalLoginManager!"
    }
}


class AppAuthState{
    override fun toString(): String {
        return "CLASS: AppAuthState!"
    }
}