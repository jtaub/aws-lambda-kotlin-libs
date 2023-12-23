package dev.jtkt.services.lambda.runtime.events

import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayProxyResponseEvent(
    val statusCode: Int = 200,
    val headers: Map<String, String> = emptyMap(),
    val multiValueHeaders: Map<String, List<String>> = emptyMap(),
    val body: String = "{}",
    val isBase64Encoded: Boolean = false,
)
