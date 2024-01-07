package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.events.TimeUtils
import dev.jtkt.services.lambda.runtime.events.HttpMethod
import dev.jtkt.services.lambda.runtime.events.apigw.v2.ApiGatewayV2Event
import dev.jtkt.services.lambda.runtime.events.apigw.v2.RequestContext
import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayV2HttpEvent(
    override val body: String = "",
    override val headers: Map<String, String> = emptyMap(),
    override val httpMethod: HttpMethod = HttpMethod.GET,
    override val isBase64Encoded: Boolean = false,
    override val requestContext: HttpRequestContext = HttpRequestContext(),
    override val stageVariables: Map<String, String> = emptyMap(),
    val cookies: List<String> = emptyList(),
    val pathParameters: Map<String, String> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    val rawPath: String = "/",
    val rawQueryString: String = "",
    val routeKey: String = "",
    val version: String = "2.0",
) : ApiGatewayV2Event

@Serializable
data class HttpRequestContext(
    override val accountId: String = "",
    override val apiId: String = "",
    override val domainName: String = "",
    override val requestId: String = "",
    override val routeKey: String = "",
    override val stage: String = "",
    override val timeEpoch: Long = TimeUtils.nowEpochMillis(),
    val domainPrefix: String = "",
    val http: Http = Http(),
) : RequestContext

@Serializable
data class Http(
    val method: HttpMethod = HttpMethod.GET,
    val path: String = "/",
    val protocol: String = "",
    val sourceIp: String = "",
    val userAgent: String = "",
)
