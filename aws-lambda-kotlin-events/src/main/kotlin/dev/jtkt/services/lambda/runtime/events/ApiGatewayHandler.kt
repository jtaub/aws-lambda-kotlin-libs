package dev.jtkt.services.lambda.runtime.events

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.InputStream
import java.io.OutputStream

@ExperimentalSerializationApi
fun interface ApiGatewayHandler : RequestStreamHandler {

    val json: Json
        get() = Json

    override fun handleRequest(input: InputStream, output: OutputStream, context: Context?) {
        val request = json.decodeFromStream<ApiGatewayProxyRequestEvent>(input)
        val response = this.handleRequest(request, context)
        json.encodeToStream(response, output)
    }

    fun handleRequest(event: ApiGatewayProxyRequestEvent, context: Context?): ApiGatewayProxyResponseEvent
}
