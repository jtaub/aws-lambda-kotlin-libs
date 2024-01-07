package dev.jtkt.services.lambda.runtime.events.apigw.auth

import dev.jtkt.services.lambda.runtime.CognitoIdentity
import kotlinx.serialization.Serializable

@Serializable
data class Authorizer(
    val jwt: JwtAuthorizer = JwtAuthorizer(),
    val lambda: Map<String, IamPolicyResponse> = emptyMap(),
    val iam: IamAuthorizer = IamAuthorizer(),
)

@Serializable
data class JwtAuthorizer(
    val claims: Map<String, String> = emptyMap(),
    val scopes: List<String> = emptyList(),
)

@Serializable
data class IamAuthorizer(
    val accessKey: String = "",
    val accountId: String = "",
    val callerId: String = "",
    val cognitoIdentity: CognitoIdentity = AmrCognitoIdentity(),
    val principalOrgId: String = "",
    val userArn: String = "",
    val userId: String = "",
) {
    @Serializable
    data class AmrCognitoIdentity(
        val amr: List<String> = emptyList(),
        override val identityId: String = "",
        override val identityPoolId: String = "",
    ) : CognitoIdentity
}
