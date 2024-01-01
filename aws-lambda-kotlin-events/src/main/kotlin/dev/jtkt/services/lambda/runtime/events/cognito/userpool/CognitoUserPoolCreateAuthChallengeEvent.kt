package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

@Serializable
data class CognitoUserPoolCreateAuthChallengeEvent(
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
        val clientMetadata: Map<String, String> = emptyMap(),
        val challengeName: String = "",
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
        val publicChallengeParameters: Map<String, String> = emptyMap(),
        val privateChallengeParameters: Map<String, String> = emptyMap(),
        val challengeMetadata: String = "",
    )
}