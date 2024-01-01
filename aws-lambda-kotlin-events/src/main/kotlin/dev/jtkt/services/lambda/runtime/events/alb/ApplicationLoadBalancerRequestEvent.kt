package dev.jtkt.services.lambda.runtime.events.alb

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationLoadBalancerRequestEvent(
    val requestContext: RequestContext = RequestContext(Elb("")),
    val httpMethod: String = "",
    val path: String = "",
    val queryStringParameters: Map<String, String> = emptyMap(),
    val multiValueQueryStringParameters: Map<String, List<String>> = emptyMap(),
    val headers: Map<String, String> = emptyMap(),
    val multiValueHeaders: Map<String, List<String>> = emptyMap(),
    val body: String = "",
    val isBase64Encoded: Boolean = false,
) {
    @Serializable
    @JvmInline
    value class Elb(val targetGroupArn: String = "")

    @JvmInline
    @Serializable
    value class RequestContext(val elb: Elb = Elb())
}