package dev.jtkt.services.lambda.runtime.events.apigw

import kotlinx.serialization.Serializable

@Serializable
data class Authorizer(
    val jwt: JWT = JWT(),
    val lambda: Map<String, LambdaAuthResponse> = emptyMap(),
    val iam: IAM = IAM(),
) {
    @Serializable
    data class JWT(
        val claims: Map<String, String> = emptyMap(),
        val scopes: List<String> = emptyList(),
    )
}

@Serializable
data class LambdaAuthResponse(
    val principalId: String = "",
    val policyDocument: PolicyDocument = PolicyDocument(),
    val context: Map<String, String> = emptyMap(),
)

@Serializable
data class PolicyDocument(
    val version: String = "",
    val statements: List<PolicyStatement> = emptyList(),
)

@Serializable
data class PolicyStatement(
    val action: String,
    val resource: String,
    val effect: Effect = Effect.ALLOW,
)

@Serializable
enum class Effect {
    ALLOW, DENY,
}

@Serializable
data class IAM(
    val accessKey: String = "",
    val accountId: String = "",
    val callerId: String = "",
    val cognitoIdentity: CognitoIdentity = CognitoIdentity(),
    val principalOrgId: String = "",
    val userArn: String = "",
    val userId: String = "",
) {
    @Serializable
    data class CognitoIdentity(
        val amr: List<String> = emptyList(),
        val identityId: String = "",
        val identityPoolId: String = "",
    )
}
