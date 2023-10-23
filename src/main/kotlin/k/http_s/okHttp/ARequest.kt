package k.http_s.okHttp

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import javax.net.ssl.SSLSocketFactory

class ARequest {
    fun simpleGetExample(url: String): String? {
        val request = Request.Builder()
            .url(url)
            .build()
        okHttpClient.newCall(request).execute().use { response ->
            return response.body?.string()
        }
    }

    fun simpleGetExampleWithPinner(url: String): String? {
        val request = Request.Builder()
            .url(url)
            .build()
        certificatePinnedClient.build().newCall(request).execute().use { response ->
            return response.body?.string()
        }
    }

    fun requestHeader(url: String): Headers {
        val request = Request.Builder()
            .url(url)
            .build()
        return request.headers
    }

    fun responseHeaders(url: String): Headers {
        val request = Request.Builder()
            .url(url)
            .build()
        okHttpClient.newCall(request).execute().use { response ->
            return response.headers
        }
    }

    fun simplePostRequest(url: String, json: String): String {
        val requestBody: RequestBody = json.toRequestBody(JSON)
        val request: Request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()
        okHttpClient.newCall(request).execute().use { response ->
            return response.body!!.string()
        }
    }

    fun getServerCertInfo(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        okHttpClientBuilder.build().newCall(request).execute().use {  response ->
            if (!response.isSuccessful) throw IOException("$response")
            else{
                response.handshake?.peerCertificates?.forEach(::println)
            }
        }
    }

    fun simpleFormPost(url: String) {
        val formBody = FormBody.Builder()
            .add("search", "Jurassic Park")
            .build()
        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .build()

        okHttpClient.newCall(request)
            .execute().use { response ->
                if (!response.isSuccessful) throw  IOException("$response")
                else {
                    println("Response Body: ")
                    println()
                    println()
                    println(response.body?.string())
                }
            }
    }

    fun bowlingJson(player1: String, player2: String): String {
        return (
                "{\"winCondition\":\"HIGH_SCORE\"," +
                        "\"name\":\"Bowling\"," +
                        "\"round\":4," +
                        "\"lastSaved\":1367702411696," +
                        "\"dateStarted\":1367702378785," +
                        "\"players\":[" +
                        "{\"name\":\"$player1\",\"history\":[10,8,6,7,8],\"color\":-13388315,\"total\":39}," +
                        "{\"name\":\"$player2\",\"history\":[6,10,5,10,10],\"color\":-48060,\"total\":41}" +
                        "]}"
                )
    }

    companion object{
        val okHttpClient = OkHttpClient()
        val okHttpClientBuilder = OkHttpClient.Builder()
        val certificatePinnedClient = OkHttpClient.Builder()
            .certificatePinner(CertificatePinner.Builder()
                .add("raw.githubusercontent.com", "sha256/qlJvUaRP4/Oodg/x84EZ52Ulu8y9eUHh++IjI8zJ2bc").build())
        val JSON: MediaType = "application/json".toMediaType()
    }
}

fun main() {
    val request = ARequest()
//    val response = request.simpleGetExample("https://raw.github.com/square/okhttp/master/README.md")
//    println(response)

//    val postBody = request.bowlingJson("Sachin","Virat")
//    val response = request.simplePostRequest("http://www.roundsapp.com/post", postBody)
//    println(response)

//    val requestHeaders: Headers = request.requestHeader("https://raw.github.com/square/okhttp/master/README.md")
//    println("Request Headers: ")
//    requestHeaders.forEach(::println)
//
//    println()
//
//    val responseHeaders: Headers = request.responseHeaders("https://raw.github.com/square/okhttp/master/README.md")
//    println("Response Headers: ")
//    responseHeaders.forEach(::println)

//    request.simpleGetExampleWithPinner("https://raw.githubusercontent.com/square/okhttp/master/README.md")
//        .also (::println)

//    request.getServerCertInfo("https://raw.githubusercontent.com/square/okhttp/master/README.md")
request.simpleFormPost("https://en.wikipedia.org/w/index.php");
}