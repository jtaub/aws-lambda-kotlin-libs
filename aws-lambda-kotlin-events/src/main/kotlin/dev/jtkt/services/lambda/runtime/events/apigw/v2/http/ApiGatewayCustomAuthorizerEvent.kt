package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayCustomAuthorizerEvent(
    val version: String = "",
    val type: String = "",
    val methodArn: String = "",
    val identitySource: String = "",
    val authorizationToken: String = "",
    val resource: String = "",
    val path: String = "",
    val httpMethod: String = "",
    val headers: Map<String, String> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    val pathParameters: Map<String, String> = emptyMap(),
    val stageVariables: Map<String, String> = emptyMap(),
    val requestContext: RequestContext = RequestContext(),
) {
    @Serializable
    data class RequestContext(
        val accountId: String = "",
        val apiId: String = "",
        val httpMethod: String = "",
        val identity: Identity = Identity(),
        val path: String = "",
        val requestId: String = "",
        val resourceId: String = "",
        val resourcePath: String = "",
        val stage: String = "",
    )

    @Serializable
    data class Identity(
        val apiKey: String = "",
        val sourceIp: String = "",
    )
}
