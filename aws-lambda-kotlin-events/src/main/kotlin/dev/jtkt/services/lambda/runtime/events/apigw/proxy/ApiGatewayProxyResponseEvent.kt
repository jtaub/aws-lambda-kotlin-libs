package dev.jtkt.services.lambda.runtime.events.apigw.proxy

import kotlinx.serialization.Serializable
import org.intellij.lang.annotations.Language

@Serializable
data class ApiGatewayProxyResponseEvent(
    val statusCode: Int = 200,
    val headers: Map<String, String> = emptyMap(),
    val multiValueHeaders: Map<String, List<String>> = emptyMap(),
    @Language("JSON") val body: String = "{}",
    val isBase64Encoded: Boolean = false,
)
