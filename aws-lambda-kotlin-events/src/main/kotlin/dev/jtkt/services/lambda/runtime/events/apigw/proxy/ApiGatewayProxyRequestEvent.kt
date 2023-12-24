package dev.jtkt.services.lambda.runtime.events.apigw.proxy

import dev.jtkt.services.lambda.runtime.events.apigw.Authorizer
import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayProxyRequestEvent(
    val version: String? = null,
    val resource: String = "/",
    val path: String = "/",
    val httpMethod: HttpMethod = HttpMethod.GET,
    val headers: Map<String, String> = emptyMap(),
    val multiValueHeaders: Map<String, List<String>> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    val multiValueQueryStringParameters: Map<String, List<String>> = emptyMap(),
    val pathParameters: Map<String, String> = emptyMap(),
    val stageVariables: Map<String, String> = emptyMap(),
    val requestContext: ProxyRequestContext = ProxyRequestContext(httpMethod = httpMethod),
    val body: String? = null,
    val isBase64Encoded: Boolean = false,
)

@Serializable
data class ProxyRequestContext(
    val accountId: String? = null,
    val stage: String? = null,
    val resourceId: String? = null,
    val requestId: String? = null,
    val operationName: String? = null,
    val identity: RequestIdentity = RequestIdentity(),
    val resourcePath: String? = null,
    val httpMethod: HttpMethod = HttpMethod.GET,
    val apiId: String? = null,
    val path: String? = null,
    val authorizer: Map<String, Authorizer> = emptyMap(),
    val extendedRequestId: String? = null,
    val requestTime: Instant = Clock.System.now(),
    val requestTimeEpoch: Long = requestTime.epochSeconds,
    val domainName: String? = null,
    val domainPrefix: String? = null,
    val protocol: String? = null,
)

@Serializable
data class RequestIdentity(
    val accessKey: String = "",
    val accountId: String = "",
    val apiKey: String = "",
    val caller: String = "",
    val cognitoAuthenticationProvider: String = "",
    val cognitoAuthenticationType: String = "",
    val cognitoIdentityId: String = "",
    val cognitoIdentityPoolId: String = "",
    val principalOrgId: String = "",
    val sourceIp: String = "",
    val user: String = "",
    val userAgent: String = "",
    val userArn: String = "",
)
