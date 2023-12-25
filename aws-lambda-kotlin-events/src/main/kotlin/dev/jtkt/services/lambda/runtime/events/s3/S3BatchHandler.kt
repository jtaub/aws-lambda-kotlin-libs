package dev.jtkt.services.lambda.runtime.events.s3

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.InputStream
import java.io.OutputStream

@ExperimentalSerializationApi
fun interface S3BatchHandler : RequestStreamHandler {

    val json: Json
        get() = Json

    override fun handleRequest(input: InputStream, output: OutputStream, context: Context?) {
        val request = json.decodeFromStream<S3BatchEvent>(input)
        val response = this.handleRequest(request, context)
        json.encodeToStream(response, output)
    }

    fun handleRequest(event: S3BatchEvent, context: Context?): S3BatchResponse
}
