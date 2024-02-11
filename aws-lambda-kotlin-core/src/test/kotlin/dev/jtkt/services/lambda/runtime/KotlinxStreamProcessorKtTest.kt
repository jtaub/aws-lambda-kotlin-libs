package dev.jtkt.services.lambda.runtime

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import java.io.ByteArrayOutputStream
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalSerializationApi
class KotlinxStreamProcessorKtTest {

    @Test
    fun `creating a request handler`() {
        // Given an input and output class
        @Serializable
        data class Input(val input: String)

        @Serializable
        data class Output(val output: String)

        // and we define a handler to uppercase input,
        val candidate = awsLambdaFunction { event: Input ->
            Output(event.input.uppercase())
        }

        // When we attempt to handle an event,
        val event = """{"input":"foobar"}"""
        val outputStream = ByteArrayOutputStream()
        candidate.handleRequest(event.byteInputStream(), outputStream)

        // Then the outputstream should have the correct result written to it.
        val actual = outputStream.toString(Charsets.UTF_8)
        val expected = """{"output":"FOOBAR"}"""
        assertEquals(expected, actual)
    }
}