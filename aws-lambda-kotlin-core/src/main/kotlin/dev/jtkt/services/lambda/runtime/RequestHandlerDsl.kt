package dev.jtkt.services.lambda.runtime

import kotlinx.serialization.serializer

/**
 * Using the provided [handler], creates an instance of a [LambdaFunction].
 *
 * Important: in order for the AWS Lambda runtime to be able to find this, you must use this as a delegate in a class.
 * For example, if you have `val handler = handlerFunction<String, Int> { it.length }`, then you need to define
 * `class MyHandler : LambdaFunction<String, Int> by handler`
 *
 */
inline fun <reified IN, reified OUT> awsLambdaFunction(
    crossinline handler: (IN) -> OUT,
): LambdaFunction<IN, OUT> {

    return object : KotlinxStreamProcessor<IN, OUT> {
        override val inputDeserializer = serializer<IN>()
        override val outputSerializer = serializer<OUT>()
        override fun process(event: IN) = handler(event)
    }
}

/**
 * Allows for creating a new [LambdaFunction] by chaining together two existing ones.
 */
inline operator fun <reified IN, reified OUT1, reified OUT2> LambdaFunction<IN, OUT1>.plus(
    other: LambdaFunction<OUT1, OUT2>,
) =
    awsLambdaFunction { event: IN ->
        other.process(this.process(event))
    }
