package dev.jtkt.services.lambda.runtime.events.s3

import kotlinx.serialization.Serializable

interface S3ObjectContext {
    val inputS3Url: String
    val outputRoute: String
    val outputToken: String
}

@Serializable
data class S3ObjectLambdaEvent(
    val configuration: Configuration = Configuration(),
    val getObjectContext: GetObjectContext = GetObjectContext(),
    val protocolVersion: String = "",
    val userIdentity: UserIdentity = UserIdentity(),
    val userRequest: UserRequest = UserRequest(),
    val xAmzRequestId: String = "",
) : S3ObjectContext by getObjectContext {
    @Serializable
    data class GetObjectContext(
        override val inputS3Url: String = "",
        override val outputRoute: String = "",
        override val outputToken: String = "",
    ) : S3ObjectContext

    @Serializable
    data class Configuration(
        val accessPointArn: String = "",
        val payload: String = "",
        val supportingAccessPointArn: String = "",
    )

    @Serializable
    data class UserRequest(
        val headers: Map<String, String> = emptyMap(),
        val url: String = "",
    )

    @Serializable
    data class UserIdentity(
        val accessKeyId: String = "",
        val accountId: String = "",
        val arn: String = "",
        val principalId: String = "",
        val type: String = "",
    )
}
