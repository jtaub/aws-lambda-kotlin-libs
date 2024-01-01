package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

@Serializable
data class CognitoUserPoolPreAuthenticationEvent(
    val request: Request = Request(),
    override val version: String = "",
    override val triggerSource: String = "",
    override val region: String = "",
    override val userPoolId: String = "",
    override val userName: String = "",
    override val callerContext: CognitoUserPoolEvent.CallerContext = CognitoUserPoolEvent.CallerContext(),
) : CognitoUserPoolEvent {
    @Serializable
    data class Request(
        val validationData: Map<String, String> = mapOf(),
        val userNotFound: Boolean = false,
        override val userAttributes: Map<String, String> = mapOf(),
    ) : CognitoUserPoolEvent.Request
}