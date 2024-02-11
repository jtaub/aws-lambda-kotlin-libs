package dev.jtkt.services.lambda.runtime

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.InputStream
import java.io.OutputStream

/**
 * Using the provided [handler], creates an instance of a [LambdaFunction].
 *
 * Important: in order for the AWS Lambda runtime to be able to find this, you must use this as a delegate in a class.
 * For example, if you have `val handler = handlerFunction<String, Int> { it.length }`, then you need to define
 * `class MyHandler : LambdaFunction<String, Int> by handler`
 */
inline fun <reified IN, reified OUT> awsLambdaFunction(
    serializationOptions: SerializationOptions = SerializationOptions.DEFAULT,
    crossinline handler: (IN) -> OUT,
): LambdaFunction<IN, OUT> {

    return object : LambdaFunction<IN, OUT> {

        @ExperimentalSerializationApi
        override fun handleRequest(input: InputStream, output: OutputStream) {
            val request = serializationOptions.inputFormat.decodeFromStream<IN>(input)
            val response = process(request)
            serializationOptions.outputFormat.encodeToStream(response, output)
        }

        override fun process(event: IN) = handler(event)
    }
}

/**
 * Syntax sugar - allows you to call implementations of this interface as if they were a real function.
 */
operator fun <IN, OUT> LambdaFunction<IN, OUT>.invoke(event: IN): OUT =
    process(event)

/**
 * Syntax sugar - allows for creating a new [LambdaFunction] by chaining together two existing ones.
 */
inline operator fun <reified IN, reified OUT1, reified OUT2> LambdaFunction<IN, OUT1>.plus(
    other: LambdaFunction<OUT1, OUT2>,
): LambdaFunction<IN, OUT2> =
    awsLambdaFunction { event: IN ->
        other.process(this.process(event))
    }
