package k.http_s.okHttp

import k.http_s.okHttp.BHttpCache.Companion.DASH
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.io.IOException

class DPostHttp {

    fun postString() {
        val postBody = """
        |Releases
        |--------
        |
        | * _1.0_ May 6, 2013
        | * _1.1_ June 15, 2013
        | * _1.2_ August 11, 2013
        |""".trimMargin()

        val request = Request.Builder()
            .url("https://api.github.com/markdown/raw")
            .post(postBody.toRequestBody(MEDIA_TYPE_MARKDOWN))
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw  IOException("Invalid response: $response")
            else {
                response.body?.string().also (::println)
            }
        }
    }

    fun postFile() {
        val filePath = "E:\\Learning\\LanguagePractice\\Kotlin-2023\\Kotlin-2023\\src\\main\\kotlin\\k\\http_s\\okHttp\\hello.txt"
        val file = File(filePath)
        val request = Request.Builder()
            .post(file.asRequestBody(MEDIA_TYPE_PLAIN_TEXT))
            .url("https://api.github.com/markdown/raw")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("$response")
            else {
                response.body!!.string().also(::println)
                println()
                println()
                println(DASH)
                println("Headers: ")
                response.headers.forEach (::println)
            }
        }
    }


    companion object {
        private val client: OkHttpClient = OkHttpClient()
        val MEDIA_TYPE_MARKDOWN = "text/x-markdown; charset=utf-8".toMediaType()
        val MEDIA_TYPE_PLAIN_TEXT = "text/plain".toMediaType()
    }
}


fun main() {
    val postClient = DPostHttp()
//    postClient.postString()

    postClient.postFile()
}