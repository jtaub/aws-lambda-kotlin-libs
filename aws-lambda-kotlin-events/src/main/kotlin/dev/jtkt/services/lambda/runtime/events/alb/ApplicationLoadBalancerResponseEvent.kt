package dev.jtkt.services.lambda.runtime.events.alb

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationLoadBalancerResponseEvent(
    val body: String = "",
    val headers: Map<String, String> = emptyMap(),
    val isBase64Encoded: Boolean = false,
    val statusCode: Int = 200,
    val statusDescription: String = "$statusCode",
)