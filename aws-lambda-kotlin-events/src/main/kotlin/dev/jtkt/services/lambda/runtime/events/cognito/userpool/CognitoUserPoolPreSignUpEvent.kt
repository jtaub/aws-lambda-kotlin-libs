package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

@Serializable
data class CognitoUserPoolPreSignUpEvent(
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
    data class Request(
        val validationData: Map<String, String> = mapOf(),
        val clientMetadata: Map<String, String> = mapOf(),
        override val userAttributes: Map<String, String> = mapOf(),
    ) : CognitoUserPoolEvent.Request

    @Serializable
    data class Response(
        val autoConfirmUser: Boolean = false,
        val autoVerifyPhone: Boolean = false,
        val autoVerifyEmail: Boolean = false,
    )
}