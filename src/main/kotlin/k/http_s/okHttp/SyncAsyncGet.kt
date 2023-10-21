package k.http_s.okHttp

import k.http_s.okHttp.BHttpCache.Companion.DASH
import okhttp3.*
import java.io.IOException

class SyncAsyncGet {
    fun synchronousRequest() {
        val request: Request = Request.Builder()
            .url(URL)
            .build()
        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                println("Headers: ")
                response.headers.forEach (::println)
                println(DASH)
                println(response.body!!.string())
            } else {
                throw IOException("Unexpected Response: $response")
            }
        }
        println("Check statement on 'SYNC': If this is printed before the network response, it means that this request is non blocking otherwise it is blocking: WARNING(may not be necessary, might be possible that the request may take less time but using this as metric here!!)")
    }

    fun asyncRequest() {
        val callback = CallbackImpl()
        val request: Request = Request.Builder()
            .url(URL)
            .build()
        client.newCall(request).enqueue(callback)
        println("Check statement on 'ASYNC': If this is printed before the network response, it means that this request is non blocking otherwise it is blocking: WARNING(may not be necessary, might be possible that the request may take less time but using this as metric here!!)")
    }

    companion object {
        private const val URL = "https://publicobject.com/helloworld.txt"
        private val client: OkHttpClient = OkHttpClient()
        private val clientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    }
}

class CallbackImpl() : Callback {
    override fun onFailure(call: Call, e: IOException) {
        e.printStackTrace()
    }

    override fun onResponse(call: Call, response: Response) {
        if (!response.isSuccessful) throw IOException("Unexpected response: $response")
        else {
            println("Headers: ")
            response.headers.forEach(::println)
            println(DASH)
            response.body!!.string().also (::println)
        }
    }
}

fun main() {
    // Synchronous request:
    val syncAsync = SyncAsyncGet()
//    syncAsync.synchronousRequest()
    syncAsync.asyncRequest()
}