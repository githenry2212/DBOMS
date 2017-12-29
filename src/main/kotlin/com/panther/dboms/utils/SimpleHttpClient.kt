/**
 *
 * @author yangfan
 * @since 2017/12/29 15:31
 *
 */
package com.panther.dboms.utils

import java.net.HttpURLConnection
import java.net.URL

class SimpleHttpClient {
    private var reqUrl: String? = null
    private var connectTimeout: Int = 5000
    private var reqMethod: Method = Method.GET
    private var dataType: ContentType? = null
    private var reqData: String? = null
    private val headers = hashMapOf<String, String>()

    fun url(url: String) {
        reqUrl = url
    }

    fun connectTimeout(timeout: Int) {
        connectTimeout = timeout
    }

    fun method(method: Method) {
        reqMethod = method
    }

    fun data(type: ContentType, data: String) {
        dataType = type
        reqData = data
    }

    fun header(name: String, value: String) {
        headers[name] = value
    }

    fun execute(): Response {
        if (reqUrl == null) error("request url must be not null")
        val conn: HttpURLConnection = URL(reqUrl).openConnection() as HttpURLConnection
        conn.connectTimeout = connectTimeout
        conn.requestMethod = reqMethod.name
        headers.forEach { name, value -> conn.addRequestProperty(name, value) }
        if (reqData != null) {
            conn.setRequestProperty("Content-Type", dataType?.value)
            conn.doOutput = true
            conn.outputStream.use { it.write(reqData?.toByteArray()) }
        }
        val respText = conn.inputStream.use { it.bufferedReader().readLines().joinToString(separator = "\n") }
        return Response(conn.responseCode, conn.responseMessage, respText)
    }

    enum class ContentType(val value: String) {
        APPLICATION_FORM_URLENCODED("application/x-www-form-urlencoded"),
        MULTIPART_FORM_DATA("multipart/form-data"),
        APPLICATION_JSON("application/json;charset=utf-8"),
        APPLICATION_OCTET_STREAM("application/octet-stream"),
        TEXT_HTML("text/html"),
        TEXT_XML("text/xml")
    }

    enum class Method {
        GET, POST, PUT, DELETE
    }

    data class Response(val code: Int, val status: String?, val respText: String?)
}

fun http(init: SimpleHttpClient.() -> Unit): SimpleHttpClient.Response {
    val httpClient = SimpleHttpClient()
    httpClient.init()
    return httpClient.execute()
}
