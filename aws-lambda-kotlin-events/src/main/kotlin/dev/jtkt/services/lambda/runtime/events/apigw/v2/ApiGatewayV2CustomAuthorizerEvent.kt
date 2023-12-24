package dev.jtkt.services.lambda.runtime.events.apigw.v2

import dev.jtkt.services.lambda.runtime.events.apigw.v2.http.HttpRequestContext
import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayV2CustomAuthorizerEvent(
    val version: String? = null,
    val type: String? = null,
    val routeArn: String? = null,
    val identitySource: List<String> = emptyList(),
    val routeKey: String? = null,
    val rawPath: String? = null,
    val rawQueryString: String? = null,
    val cookies: List<String> = emptyList(),
    val headers: Map<String, String> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    val requestContext: RequestContext = HttpRequestContext(),
    val pathParameters: Map<String, String> = emptyMap(),
    val stageVariables: Map<String, String> = emptyMap(),
)
