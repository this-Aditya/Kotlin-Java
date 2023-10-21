package k.http_s.okHttp

import k.http_s.okHttp.BHttpCache.Companion.DASH
import okhttp3.*
import java.io.IOException

class CSyncAsyncGet {
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

    fun reqResHeaders() {
        val request = Request.Builder()
            .url("https://api.github.com/repos/square/okhttp/issues")
            .header("User-Agent", "OkHttp Headers.java")
            .header("Accept", "application/json; q=0.5")
            .addHeader("Accept", "application/vnd.github.v3+json")
            .build()

//        request.headers.forEach (::println)

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val server: String? = response.header("Server")
            val date: String? = response.header("Date")
            val vary: List<String> = response.headers("Vary")
            val vary2: String? = response.header("Vary")
            println("Server: $server")
            println("Date: $date")
            println("Vary: $vary")
            println("Vary2: $vary2")
            println()
            println(DASH)
            println()
            println("Headers: ")
            response.headers.forEach(::println)
        }
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
    val syncAsync = CSyncAsyncGet()
//    syncAsync.synchronousRequest()
//    syncAsync.asyncRequest()

    syncAsync.reqResHeaders()
}