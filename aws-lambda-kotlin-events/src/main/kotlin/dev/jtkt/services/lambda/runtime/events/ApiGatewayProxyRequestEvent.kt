package dev.jtkt.services.lambda.runtime.events

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
    val requestContext: ProxyRequestContext = ProxyRequestContext(),
    val body: String? = null,
    val isBase64Encoded: Boolean = false,
)

@Serializable
enum class HttpMethod {
    GET, PUT, POST, DELETE, HEAD, OPTIONS,
}

@Serializable
data class ProxyRequestContext(
    val accountId: String? = null,
    val stage: String? = null,
    val resourceId: String? = null,
    val requestId: String? = null,
    val operationName: String? = null,
    val identity: RequestIdentity = RequestIdentity(),
    val resourcePath: String? = null,
    val httpMethod: String? = null,
    val apiId: String? = null,
    val path: String? = null,
    val authorizer: Map<String, Authorizer> = emptyMap(),
    val extendedRequestId: String? = null,
    val requestTime: String? = null,
    val requestTimeEpoch: Long? = null,
    val domainName: String? = null,
    val domainPrefix: String? = null,
    val protocol: String? = null,
)

@Serializable
data class RequestIdentity(
    val cognitoIdentityPoolId: String? = null,
    val accountId: String? = null,
    val cognitoIdentityId: String? = null,
    val caller: String? = null,
    val apiKey: String? = null,
    val principalOrgId: String? = null,
    val sourceIp: String? = null,
    val cognitoAuthenticationType: String? = null,
    val cognitoAuthenticationProvider: String? = null,
    val userArn: String? = null,
    val userAgent: String? = null,
    val user: String? = null,
    val accessKey: String? = null,
)
