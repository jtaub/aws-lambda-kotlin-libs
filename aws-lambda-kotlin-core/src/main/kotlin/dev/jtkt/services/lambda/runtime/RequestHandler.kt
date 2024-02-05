package dev.jtkt.services.lambda.runtime

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.InputStream
import java.io.OutputStream

@ExperimentalSerializationApi
interface LambdaHandler<IN, OUT> {

    companion object {
        val jsonFormatDefaults = Json {
            coerceInputValues = true
            encodeDefaults = true
            explicitNulls = true
            ignoreUnknownKeys = true
            useAlternativeNames = false
        }
    }

    /**
     * Example: `S3BatchEvent.serializer()`
     */
    val inputDeserializer: KSerializer<IN>

    /**
     * Example: `S3BatchResponse.serializer()`
     */
    val outputSerializer: KSerializer<OUT>

    /**
     * Configure how the input json should be handled.
     */
    val inputFormat: Json
        get() = jsonFormatDefaults

    /**
     * Configure how the output json should be handled.
     */
    val outputFormat: Json
        get() = jsonFormatDefaults

    /**
     * This is the function which will actually be called by the AWS Lambda Java runtime.
     * It requires a method with this signature. This method shouldn't be overridden in most circumstances.
     */
    fun handleRequest(input: InputStream, output: OutputStream) {
        val request = outputFormat.decodeFromStream(inputDeserializer, input)
        val response = process(request)
        inputFormat.encodeToStream(outputSerializer, response, output)
    }

    operator fun invoke(input: InputStream, output: OutputStream) = handleRequest(input, output)

    /**
     * Put your actual "business logic" here.
     */
    fun process(event: IN): OUT
}
