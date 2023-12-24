package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import kotlinx.serialization.Serializable
import org.intellij.lang.annotations.Language

@Serializable
data class ApiGatewayV2HttpResponse(
    val statusCode: Int = 200,
    val headers: Map<String, String> = emptyMap(),
    val multiValueHeaders: Map<String, List<String>> = emptyMap(),
    val cookies: List<String> = emptyList(),
    @Language("JSON") val body: String = "{}",
    val isBase64Encoded: Boolean = false,
)
