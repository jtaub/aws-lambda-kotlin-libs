package dev.jtkt.services.lambda.runtime.events.appsync

import kotlinx.serialization.Serializable

@Serializable
data class AppSyncLambdaAuthorizerEvent(
    val requestContext: RequestContext = RequestContext(),
    val authorizationToken: String = "",
) {
    @Serializable
    data class RequestContext(
        val apiId: String = "",
        val accountId: String = "",
        val requestId: String = "",
        val queryDocument: String = "",
        val operationName: String = "",
        val variables: Map<String, String> = emptyMap(),
    )
}