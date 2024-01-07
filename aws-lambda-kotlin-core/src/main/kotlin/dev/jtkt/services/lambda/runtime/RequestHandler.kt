package dev.jtkt.services.lambda.runtime

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.InputStream
import java.io.OutputStream

typealias RequestHandler<IN, OUT> = (IN, Context?) -> OUT
typealias RequestStreamHandler = (InputStream, OutputStream, Context?) -> Unit

@ExperimentalSerializationApi
inline fun <reified IN, reified OUT> newLambdaHandler(
    json: Json = Json,
    crossinline handler: RequestHandler<IN, OUT>,
): RequestStreamHandler {
    return { inputStream: InputStream, outputStream: OutputStream, context: Context? ->
        val request = json.decodeFromStream<IN>(inputStream)
        val response = handler(request, context)
        json.encodeToStream(response, outputStream)
    }
}