package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

@Serializable
data class CognitoUserPoolMigrateUserEvent(
    override val request: Request = Request(),
    val response: Response = Response(),
    override val version: String = "",
    override val triggerSource: String = "",
    override val region: String = "",
    override val userPoolId: String = "",
    override val userName: String = "",
    override val callerContext: CognitoUserPoolEvent.CallerContext = CognitoUserPoolEvent.CallerContext(),
) : CognitoUserPoolEvent {
    @Serializable
    class Request(
        val userName: String = "",
        val password: String = "",
        val validationData: Map<String, String> = mapOf(),
        val clientMetadata: Map<String, String> = mapOf(),
        override val userAttributes: Map<String, String> = emptyMap(),
    ) : CognitoUserPoolEvent.Request

    @Serializable
    data class Response(
        val userAttributes: Map<String, String> = mapOf(),
        val finalUserStatus: String = "",
        val messageAction: String = "",
        val desiredDeliveryMediums: List<String> = listOf(),
        val forceAliasCreation: Boolean = false,
    )
}