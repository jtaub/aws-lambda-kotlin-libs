package dev.jtkt.services.lambda.runtime.events

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalSerializationApi
class ApiGatewayHandlerTest {

    private val candidate = ApiGatewayHandler { event, _ ->
        ApiGatewayProxyResponseEvent(body = """{"msg": "Hello, ${event.body}!"}""")
    }

    @Test
    fun simpleTest() {
        // Given
        val input = ApiGatewayProxyRequestEvent(body = "World")

        // When
        val inputStream = Json.encodeToString(input).byteInputStream()
        val outputStream = ByteArrayOutputStream()
        candidate.handleRequest(inputStream, outputStream, null)

        // Then
        val actual = Json.decodeFromString<ApiGatewayProxyResponseEvent>(outputStream.toString(Charsets.UTF_8))
        val expected = ApiGatewayProxyResponseEvent(body = """{"msg": "Hello, World!"}""")
        assertEquals(expected, actual)
    }
}
