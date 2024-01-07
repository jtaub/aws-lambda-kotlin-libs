package dev.jtkt.services.lambda.runtime.events.apigw.proxy

import dev.jtkt.services.lambda.runtime.newLambdaHandler
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalSerializationApi
class ApiGatewayProxyHandlerTest {

    private val candidate = newLambdaHandler<ApiGatewayProxyRequestEvent, ApiGatewayProxyResponseEvent> { event, _ ->
        ApiGatewayProxyResponseEvent(body = """{"msg": "Hello, ${event.body}!"}""")
    }

    @Test
    fun simpleTest() {
        // Given
        val input = ApiGatewayProxyRequestEvent(body = "World")

        // When
        val inputStream = Json.encodeToString(input).byteInputStream()
        val outputStream = ByteArrayOutputStream()
        candidate(inputStream, outputStream, null)

        // Then
        val actual = Json.decodeFromString<ApiGatewayProxyResponseEvent>(outputStream.toString(Charsets.UTF_8))
        val expected = ApiGatewayProxyResponseEvent(body = """{"msg": "Hello, World!"}""")
        assertEquals(expected, actual)
    }
}
