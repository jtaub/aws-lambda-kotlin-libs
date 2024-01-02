package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import dev.jtkt.services.lambda.runtime.events.apigw.v2.ApiGatewayV2Event
import dev.jtkt.services.lambda.runtime.events.apigw.v2.RequestContext
import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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
