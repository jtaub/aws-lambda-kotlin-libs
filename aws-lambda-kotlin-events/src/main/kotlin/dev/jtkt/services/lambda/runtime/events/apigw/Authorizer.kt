package dev.jtkt.services.lambda.runtime.events.apigw

import dev.jtkt.services.lambda.runtime.events.apigw.v2.IamPolicyResponse
import kotlinx.serialization.Serializable
import com.amazonaws.services.lambda.runtime.CognitoIdentity as ICognitoIdentity

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
    ) : ICognitoIdentity {
        override fun getIdentityId() = identityId
        override fun getIdentityPoolId() = identityPoolId
    }
}
