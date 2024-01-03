package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

@Serializable
data class CognitoUserPoolVerifyAuthChallengeResponseEvent(
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
        val clientMetadata: Map<String, String> = mapOf(),
        val privateChallengeParameters: Map<String, String> = mapOf(),
        val challengeAnswer: String = "",
        val userNotFound: Boolean = false,
        override val userAttributes: Map<String, String> = mapOf(),
    ) : CognitoUserPoolEvent.Request

    @Serializable
    data class Response(
        val answerCorrect: Boolean = false,
    )
}