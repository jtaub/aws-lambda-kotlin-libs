package dev.jtkt.services.lambda.runtime

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Provides a much more convenient syntax for defining and instantiating a [LambdaHandler].
 * However, this generally cannot be used with the AWS Java runtime, which expects a named class to be defined.
 */
@ExperimentalSerializationApi
inline fun <reified IN, reified OUT> newLambdaHandler(
    inputFormat: Json = LambdaHandler.jsonFormatDefaults,
    outputFormat: Json = LambdaHandler.jsonFormatDefaults,
    crossinline handler: (IN) -> OUT,
): LambdaHandler<IN, OUT> {

    return object : LambdaHandler<IN, OUT> {
        override val inputDeserializer = serializer<IN>()
        override val inputFormat = inputFormat
        override val outputFormat = outputFormat
        override val outputSerializer = serializer<OUT>()
        override fun process(event: IN) = handler(event)
    }
}

/**
 * Allows for creating a new [LambdaHandler] by chaining together two existing ones.
 */
@ExperimentalSerializationApi
inline operator fun <reified IN, reified OUT1, reified OUT2> LambdaHandler<IN, OUT1>.plus(
    other: LambdaHandler<OUT1, OUT2>,
) =
    newLambdaHandler { event: IN ->
        other.process(this.process(event))
    }
