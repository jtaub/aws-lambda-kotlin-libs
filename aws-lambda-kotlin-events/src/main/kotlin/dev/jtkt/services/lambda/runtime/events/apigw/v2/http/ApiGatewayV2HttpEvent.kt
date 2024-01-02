package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import dev.jtkt.services.lambda.runtime.events.apigw.v2.ApiGatewayV2Event
import dev.jtkt.services.lambda.runtime.events.apigw.v2.RequestContext
import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayV2HttpEvent(
    override val body: String = "",
    override val headers: Map<String, String> = emptyMap(),
    override val httpMethod: HttpMethod = HttpMethod.GET,
    override val isBase64Encoded: Boolean = false,
    override val requestContext: RequestContext = HttpRequestContext(),
    override val stageVariables: Map<String, String> = emptyMap(),
    val cookies: List<String> = emptyList(),
    val pathParameters: Map<String, String> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    val rawPath: String = "/",
    val rawQueryString: String = "",
    val routeKey: String = "",
    val version: String = "",
) : ApiGatewayV2Event
