package dev.jtkt.services.lambda.runtime.events.appsync

import dev.jtkt.services.lambda.runtime.events.apigw.auth.SimpleIamPolicyResponse
import kotlinx.serialization.Serializable

@Serializable
data class AppSyncLambdaAuthorizerResponse(
    override val isAuthorized: Boolean = false,
    val resolverContext: Map<String, String> = emptyMap(),
    val deniedFields: List<String> = emptyList(),
    val ttlOverride: Int = 0,
) : SimpleIamPolicyResponse {
    override val context: Map<String, String> = resolverContext
}