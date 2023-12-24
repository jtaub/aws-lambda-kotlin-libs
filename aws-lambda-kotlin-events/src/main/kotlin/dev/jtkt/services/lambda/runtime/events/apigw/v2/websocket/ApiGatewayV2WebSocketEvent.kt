package dev.jtkt.services.lambda.runtime.events.apigw.v2.websocket
import dev.jtkt.services.lambda.runtime.events.apigw.Authorizer
import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import dev.jtkt.services.lambda.runtime.events.apigw.proxy.RequestIdentity
import dev.jtkt.services.lambda.runtime.events.apigw.v2.ApiGatewayV2Event
import dev.jtkt.services.lambda.runtime.events.apigw.v2.RequestContext
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class ApiGatewayV2WebSocketEvent(
    override val body: String = "",
    override val headers: Map<String, String> = emptyMap(),
    override val httpMethod: HttpMethod = HttpMethod.GET,
    override val isBase64Encoded: Boolean = false,
    val multiValueHeaders: Map<String, List<String>> = emptyMap(),
    val multiValueQueryStringParameters: Map<String, List<String>> = emptyMap(),
    val path: String = "/",
    val pathParameters: Map<String, String> = emptyMap(),
    val queryStringParameters: Map<String, String> = emptyMap(),
    override val requestContext: WebSocketRequestContext = WebSocketRequestContext(httpMethod=httpMethod),
    val resource: String = "/",
    override val stageVariables: Map<String, String> = emptyMap(),
) : ApiGatewayV2Event {
    @Serializable
    data class WebSocketRequestContext(
        override val accountId: String = "",
        override val apiId: String = "",
        val authorizer: Authorizer = Authorizer(),
        val connectedAt: Long = 0L,
        val connectionId: String = "",
        override val domainName: String = "",
        val error: String = "",
        val eventType: String = "",
        val extendedRequestId: String = "",
        val httpMethod: HttpMethod = HttpMethod.GET,
        val identity: RequestIdentity = RequestIdentity(),
        val integrationLatency: String = "",
        val messageDirection: String = "",
        val messageId: String = "",
        override val requestId: String = "",
        val requestTime: Instant = Clock.System.now(),
        val requestTimeEpoch: Long = requestTime.epochSeconds,
        val resourceId: String = "",
        val resourcePath: String = "",
        override val routeKey: String = "",
        override val stage: String = "",
        val status: String = "",
    ) : RequestContext {
        override val time: Instant = requestTime
        override val timeEpoch: Long = requestTimeEpoch
    }
}
