package dev.jtkt.services.lambda.runtime.events.apigw.v2

import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import kotlinx.datetime.Instant

/**
 * Contains fields common to both the Http and Websocket API gateway events.
 */
interface ApiGatewayV2Event {
    val body: String
    val headers: Map<String, String>
    val httpMethod: HttpMethod
    val isBase64Encoded: Boolean
    val requestContext: RequestContext
    val stageVariables: Map<String, String>
}

interface RequestContext {
    val accountId: String
    val apiId: String
    val domainName: String
    val requestId: String
    val routeKey: String
    val stage: String
    val time: Instant
    val timeEpoch: Long
}
