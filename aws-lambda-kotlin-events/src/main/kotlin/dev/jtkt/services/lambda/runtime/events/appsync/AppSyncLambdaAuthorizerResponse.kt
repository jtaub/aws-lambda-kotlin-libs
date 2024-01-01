package dev.jtkt.services.lambda.runtime.events.appsync

import kotlinx.serialization.Serializable

@Serializable
data class AppSyncLambdaAuthorizerResponse(
    val isAuthorized: Boolean = false,
    val resolverContext: Map<String, String> = emptyMap(),
    val deniedFields: List<String> = emptyList(),
    val ttlOverride: Int = 0,
)