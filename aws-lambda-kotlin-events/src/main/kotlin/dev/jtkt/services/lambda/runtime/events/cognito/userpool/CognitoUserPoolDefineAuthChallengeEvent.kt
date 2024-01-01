package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

@Serializable
data class CognitoUserPoolDefineAuthChallengeEvent(
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
        val session: List<ChallengeResult> = listOf(),
        val userNotFound: Boolean = false,
        override val userAttributes: Map<String, String> = emptyMap(),
    ) : CognitoUserPoolEvent.Request

    @Serializable
    data class ChallengeResult(
        val challengeName: String = "",
        val challengeResult: Boolean = false,
        val challengeMetadata: String = "",
    )

    @Serializable
    data class Response(
        val challengeName: String = "",
        val issueTokens: Boolean = false,
        val failAuthentication: Boolean = false,
    )
}