package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

@Serializable
data class CognitoUserPoolCustomMessageEvent(
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
        val clientMetadata: Map<String, String> = mapOf(),
        val codeParameter: String = "",
        val usernameParameter: String = "",
        override val userAttributes: Map<String, String> = emptyMap(),
    ) : CognitoUserPoolEvent.Request

    @Serializable
    data class Response(
        val smsMessage: String = "",
        val emailMessage: String = "",
        val emailSubject: String = "",
    )
}