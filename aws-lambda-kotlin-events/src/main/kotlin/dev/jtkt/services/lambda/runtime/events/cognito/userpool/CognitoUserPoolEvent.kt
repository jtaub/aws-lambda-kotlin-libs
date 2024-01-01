package dev.jtkt.services.lambda.runtime.events.cognito.userpool

import kotlinx.serialization.Serializable

interface CognitoUserPoolEvent {

    val request: Request
    val version: String
    val triggerSource: String
    val region: String
    val userPoolId: String
    val userName: String
    val callerContext: CallerContext

    interface Request {
        val userAttributes: Map<String, String>
    }

    @Serializable
    data class CallerContext(
        val awsSdkVersion: String = "",
        val clientId: String = "",
    )
}