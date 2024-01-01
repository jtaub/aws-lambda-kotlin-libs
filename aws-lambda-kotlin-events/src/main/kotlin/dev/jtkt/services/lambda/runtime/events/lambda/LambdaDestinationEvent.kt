package dev.jtkt.services.lambda.runtime.events.lambda

import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable
import kotlinx.datetime.Instant

@Serializable
data class LambdaDestinationEvent(
    val version: String = "",
    val timestamp: Instant = Clock.System.now(),
    val requestContext: RequestContext = RequestContext(),
    val requestPayload: Map<String, String> = mapOf(),
    val responseContext: Map<String, String> = mapOf(),
    val responsePayload: Map<String, String> = mapOf(),
) {
    @Serializable
    data class RequestContext(
        val requestId: String = "",
        val functionArn: String = "",
        val condition: String = "",
        val approximateInvokeCount: Int = 0,
    )
}