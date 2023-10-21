package k.http_s.okHttp

import k.http_s.okHttp.ARequest.Companion.okHttpClientBuilder
import k.http_s.okHttp.BHttpCache.Companion.DASH
import k.http_s.okHttp.BHttpCache.Companion.SQUARE_URL
import okhttp3.Cache
import okhttp3.Request
import okhttp3.Response
import java.io.File

class BHttpCache {
    fun saveHttpCache(url: String): Response {
        val client = okHttpClientBuilder
            .cache(
                Cache(
                    directory = File("\"E:\\Learning\\LanguagePractice\\Kotlin-2023\\Kotlin-2023\\src\\main\\kotlin\\k\\http_s\\okHttp\\BHttpCache.txt\""),
                    maxSize = 50L * 1024L * 1024L
                )
            )
            .build()
        val request: Request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request)
            .execute().use { return it }
    }
    companion object {
        const val DASH: String = "---------------------------------------------------------------------------------------------------------------------------------"
        const val SQUARE_URL = "https://raw.github.com/square/okhttp/master/README.md"
    }
}

fun main() {
    val cacheObj = BHttpCache()
    cacheObj.saveHttpCache(SQUARE_URL)
        .use { response ->
            println("Response Headers: ")
            response.headers.forEach (::println)
            println(DASH)
//            println("Response Body: ")
//            println(response.body.string())
            println(DASH)
            println("Response message: ")
            println(response.message)
            println(DASH)
            println("Cache Response: ")
            println(response.cacheResponse)
            println(DASH)
            println("Protcocl: ")
            println(response.protocol)
        }
}