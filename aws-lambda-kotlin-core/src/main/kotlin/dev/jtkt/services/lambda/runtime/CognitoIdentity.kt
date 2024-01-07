package dev.jtkt.services.lambda.runtime

interface CognitoIdentity {
    val identityId: String
    val identityPoolId: String
}