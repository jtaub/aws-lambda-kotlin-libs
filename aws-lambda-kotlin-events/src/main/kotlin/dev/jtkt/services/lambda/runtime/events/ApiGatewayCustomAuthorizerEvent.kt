package dev.jtkt.services.lambda.runtime.events

import kotlinx.serialization.Serializable

@Serializable
data class APIGatewayCustomAuthorizerEvent(
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
        val path: String = "",
        val accountId: String = "",
        val resourceId: String = "",
        val stage: String = "",
        val requestId: String = "",
        val identity: Identity = Identity(),
        val resourcePath: String = "",
        val httpMethod: String = "",
        val apiId: String = "",
    )

    @Serializable
    data class Identity(
        val apiKey: String = "",
        val sourceIp: String = "",
    )
}
