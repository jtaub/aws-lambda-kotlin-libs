package dev.jtkt.services.lambda.runtime.events.apigw.auth

import kotlinx.serialization.Serializable

sealed interface IamPolicyResponse {

    val principalId: String
    val policyDocument: PolicyDocument
    val context: Map<String, String>

    companion object {
        const val EXECUTE_API_INVOKE = "execute-api:Invoke"
        const val VERSION_2012_10_17 = "2012-10-17"
    }
}

@Serializable
data class PolicyDocument(
    val statement: List<Statement> = emptyList(),
    val version: String = IamPolicyResponse.VERSION_2012_10_17,
)

@Serializable
data class Statement(
    val action: String = IamPolicyResponse.EXECUTE_API_INVOKE,
    val condition: Map<String, Map<String, String>> = emptyMap(),
    val effect: Effect = Effect.ALLOW,
    val resource: List<String> = emptyList(),
) {
    @Serializable
    enum class Effect(val value: String) {
        ALLOW("Allow"), DENY("Deny")
    }
}

/**
 * The IAM Policy Response required for API Gateway HTTP APIs
 */
@Serializable
data class HttpApiIamPolicyResponse(
    override val context: Map<String, String> = emptyMap(),
    override val policyDocument: PolicyDocument = PolicyDocument(),
    override val principalId: String = "",
) : IamPolicyResponse

/**
 * The IAM Policy Response required for API Gateway REST APIs
 */
@Serializable
data class RestApiIamPolicyResponse(
    override val context: Map<String, String> = emptyMap(),
    override val policyDocument: PolicyDocument = PolicyDocument(),
    override val principalId: String = "",
    val usageIdentifierKey: String = "",
) : IamPolicyResponse

interface SimpleIamPolicyResponse {
    val isAuthorized: Boolean
    val context: Map<String, String>
}
