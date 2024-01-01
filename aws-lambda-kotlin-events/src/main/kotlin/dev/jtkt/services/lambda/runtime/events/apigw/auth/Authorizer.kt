package dev.jtkt.services.lambda.runtime.events.apigw.auth

import kotlinx.serialization.Serializable

@Serializable
data class Authorizer(
    val jwt: JWT = JWT(),
    val lambda: Map<String, IamPolicyResponse> = emptyMap(),
    val iam: IAM = IAM(),
)

@Serializable
data class JWT(
    val claims: Map<String, String> = emptyMap(),
    val scopes: List<String> = emptyList(),
)

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
