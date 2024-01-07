package dev.jtkt.services.lambda.runtime.events.apigw.v2.websocket

import dev.jtkt.services.lambda.runtime.CognitoIdentity
import dev.jtkt.services.lambda.runtime.events.TimeUtils.nowEpochMillis
import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import dev.jtkt.services.lambda.runtime.events.apigw.auth.Authorizer
import dev.jtkt.services.lambda.runtime.events.apigw.v2.ApiGatewayV2Event
import dev.jtkt.services.lambda.runtime.events.apigw.v2.RequestContext
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayV2WebSocketEvent(
    override val body: String = "",
    override val headers: Map<String, String> = emptyMap(),
    override val httpMethod: HttpMethod = HttpMethod.GET,
    override val isBase64Encoded: Boolean = false,
    override val requestContext: WebSocketRequestContext = WebSocketRequestContext(httpMethod = httpMethod),
    override val stageVariables: Map<String, String> = emptyMap(),
    val path: String = "/",
    val pathParameters: Map<String, String> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    val resource: String = "/",
) : ApiGatewayV2Event {
    @Serializable
    data class WebSocketRequestContext(
        override val accountId: String = "",
        override val apiId: String = "",
        override val domainName: String = "",
        override val requestId: String = "",
        override val routeKey: String = "",
        override val stage: String = "",
        override val timeEpoch: Long = nowEpochMillis(),
        val authorizer: Authorizer = Authorizer(),
        val connectedAt: Long = 0L,
        val connectionId: String = "",
        val error: String = "",
        val eventType: String = "",
        val extendedRequestId: String = "",
        val httpMethod: HttpMethod = HttpMethod.GET,
        val identity: RequestIdentity = RequestIdentity(),
        val integrationLatency: String = "",
        val messageDirection: String = "",
        val messageId: String = "",
        val requestTimeEpoch: Long = timeEpoch,
        val resourceId: String = "",
        val resourcePath: String = "",
        val status: String = "",
    ) : RequestContext {

        val requestTime: Instant = Instant.fromEpochMilliseconds(requestTimeEpoch)
    }
}

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
) : CognitoIdentity {
    override val identityId = cognitoIdentityId
    override val identityPoolId = cognitoIdentityPoolId
}