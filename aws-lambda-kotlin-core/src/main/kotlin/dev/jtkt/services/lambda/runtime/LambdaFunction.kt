package dev.jtkt.services.lambda.runtime

import java.io.InputStream
import java.io.OutputStream

/**
 * A representation of an AWS Lambda function.
 *
 * The [handleRequest] method will be called by the Lambda runtime.
 */
interface LambdaFunction<IN, OUT> {

    /**
     * Put your actual "business logic" here.
     */
    fun process(event: IN): OUT

    /**
     * This is the function that will actually be called by the AWS Lambda Java runtime.
     * You shouldn't need to implement this yourself unless you have some very specific de/serialization requirements.
     */
    fun handleRequest(input: InputStream, output: OutputStream)
}

/**
 * Syntax sugar - allows you to call implementations of this interface as if they were a real function.
 */
operator fun <IN, OUT> LambdaFunction<IN, OUT>.invoke(event: IN): OUT = process(event)