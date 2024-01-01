package dev.jtkt.services.lambda.runtime.events.alb

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationLoadBalancerResponseEvent(
    val statusCode: Int = 0,
    val statusDescription: String = "",
    val isBase64Encoded: Boolean = false,
    val headers: Map<String, String> = emptyMap(),
    val multiValueHeaders: Map<String, List<String>> = emptyMap(),
    val body: String = "",
)