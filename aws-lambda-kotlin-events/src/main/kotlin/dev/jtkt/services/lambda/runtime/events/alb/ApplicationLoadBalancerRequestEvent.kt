package dev.jtkt.services.lambda.runtime.events.alb

import dev.jtkt.services.lambda.runtime.events.HttpMethod
import kotlinx.serialization.Serializable

@Serializable
data class ApplicationLoadBalancerRequestEvent(
    val body: String = "",
    val headers: Map<String, String> = emptyMap(),
    val httpMethod: HttpMethod = HttpMethod.GET,
    val isBase64Encoded: Boolean = false,
    val path: String = "",
    val queryStringParameters: Map<String, String> = emptyMap(),
    val requestContext: RequestContext = RequestContext(Elb("")),
) {
    @Serializable
    data class Elb(val targetGroupArn: String = "")

    @Serializable
    data class RequestContext(val elb: Elb = Elb())
}