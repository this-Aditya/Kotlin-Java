package k.http_s.okHttp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class ELoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val t1 = System.currentTimeMillis()
        println("Sending request: ${request.url} on ${chain.connection()} with headers ${request.headers}")
        val response: Response = chain.proceed(request)
        val t2 = System.currentTimeMillis()
        println("Received Response for: ${response.request.url} in ${t2-t1}(ms) with response headers ${response.headers}")
        return response
    }

    fun doInterceptRequest() {
        val request: Request = Request.Builder()
            .url(BASE_URL)
            .header("User-Agent", "OkHttp Example")
            .build()

        client.addInterceptor(ELoggingInterceptor()).build().
                newCall(request)
            .execute()
            .use { response ->
                println()
                println()
                println("Response -> ")
                response.body?.string().also (::println)
            }
    }

    companion object {
        val client: OkHttpClient.Builder = OkHttpClient.Builder()
        const val BASE_URL = "http://www.publicobject.com/helloworld.txt"
    }
}


fun main() {
    ELoggingInterceptor().doInterceptRequest()
}