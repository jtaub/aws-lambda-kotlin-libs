package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import dev.jtkt.services.lambda.runtime.events.apigw.v2.ApiGatewayV2Event
import dev.jtkt.services.lambda.runtime.events.apigw.v2.RequestContext
import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayV2HttpEvent(
    override val body: String = "",
    val cookies: List<String> = emptyList(),
    override val headers: Map<String, String> = emptyMap(),
    override val httpMethod: HttpMethod = HttpMethod.GET,
    override val isBase64Encoded: Boolean = false,
    val pathParameters: Map<String, String> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    val rawPath: String = "/",
    val rawQueryString: String = "",
    override val requestContext: RequestContext = HttpRequestContext(),
    val routeKey: String = "",
    override val stageVariables: Map<String, String> = emptyMap(),
    val version: String = "",
) : ApiGatewayV2Event
