package dev.jtkt.services.lambda.runtime.events.s3

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URLDecoder

typealias S3Event = S3EventNotification

@Serializable
data class S3EventNotification(
    @SerialName("Records") val records: List<S3EventNotificationRecord> = emptyList(),
)

@Serializable
data class S3EventNotificationRecord(
    val awsRegion: String = "",
    val eventName: String = "",
    val eventSource: String = "aws:s3",
    val eventTime: Instant = Clock.System.now(),
    val eventVersion: String = "2.0",
    val requestParameters: RequestParametersEntity = RequestParametersEntity(),
    val responseElements: ResponseElementsEntity = ResponseElementsEntity(),
    val s3: S3Entity = S3Entity(),
    val userIdentity: UserIdentityEntity = UserIdentityEntity(),
)

@Serializable
data class RequestParametersEntity(
    @SerialName("sourceIPAddress") val sourceIpAddress: String = "",
)

@Serializable
data class ResponseElementsEntity(
    @SerialName("x-amz-id-2") val xAmzId2: String = "",
    @SerialName("x-amz-request-id") val xAmzRequestId: String = "",
)

@Serializable
data class S3Entity(
    val configurationId: String = "",
    val bucket: S3BucketEntity = S3BucketEntity(),
    @SerialName("object") val s3Object: S3ObjectEntity = S3ObjectEntity(),
    val s3SchemaVersion: String = "1.0",
)


@Serializable
data class S3BucketEntity(
    val arn: String = "",
    val name: String = "",
    val ownerIdentity: UserIdentityEntity = UserIdentityEntity(),
)

@Serializable
data class S3ObjectEntity(
    val key: String = "",
    val size: Long = 0,
    val eTag: String = "",
    val versionId: String = "",
    val sequencer: String = "",
) {
    val urlDecodedKey by lazy { URLDecoder.decode(key, Charsets.UTF_8) }
}

@Serializable
data class UserIdentityEntity(
    val principalId: String = "",
)
