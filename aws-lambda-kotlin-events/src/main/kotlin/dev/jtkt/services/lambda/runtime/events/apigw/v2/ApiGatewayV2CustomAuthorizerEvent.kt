package dev.jtkt.services.lambda.runtime.events.apigw.v2

import dev.jtkt.services.lambda.runtime.events.apigw.v2.http.HttpRequestContext
import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayV2CustomAuthorizerEvent(
    val cookies: List<String> = emptyList(),
    val headers: Map<String, String> = emptyMap(),
    val identitySource: List<String> = emptyList(),
    val pathParameters: Map<String, String> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    val rawPath: String = "",
    val rawQueryString: String = "",
    val requestContext: RequestContext = HttpRequestContext(),
    val routeArn: String = "",
    val routeKey: String = "",
    val stageVariables: Map<String, String> = emptyMap(),
    val type: String = "",
    val version: String = "2.0",
)
