package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

@Serializable
data class CognitoUserPoolPreTokenGenerationEvent(
    val request: Request = Request(),
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
        val groupConfiguration: GroupConfiguration = GroupConfiguration(),
        override val userAttributes: Map<String, String> = mapOf(),
    ) : CognitoUserPoolEvent.Request

    @Serializable
    data class GroupConfiguration(
        val groupsToOverride: List<String> = listOf(),
        val iamRolesToOverride: List<String> = listOf(),
        val preferredRole: String = "",
    )

    @Serializable
    @JvmInline
    value class Response(
        val claimsOverrideDetails: ClaimsOverrideDetails = ClaimsOverrideDetails(),
    )

    @Serializable
    data class ClaimsOverrideDetails(
        val claimsToAddOrOverride: Map<String, String> = mapOf(),
        val claimsToSuppress: List<String> = listOf(),
        val groupOverrideDetails: GroupConfiguration = GroupConfiguration(),
    )
}