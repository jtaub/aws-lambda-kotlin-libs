package dev.jtkt.services.lambda.runtime.events.model.s3

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import java.net.URLDecoder

@JvmInline
@Serializable
value class S3EventNotification(
    val records: List<S3EventNotificationRecord> = emptyList(),
)

@JvmInline
@Serializable
value class UserIdentityEntity(
    val principalId: String,
)

@Serializable
data class S3BucketEntity(
    val name: String,
    val ownerIdentity: UserIdentityEntity,
    val arn: String,
)

@Serializable
data class S3ObjectEntity(
    val key: String,
    val size: Long? = null,
    val eTag: String? = null,
    val versionId: String? = null,
    val sequencer: String? = null,
) {
    val urlDecodedKey by lazy { URLDecoder.decode(key, Charsets.UTF_8) }
}

@Serializable
data class S3Entity(
    val configurationId: String,
    val bucket: S3BucketEntity,
    val `object`: S3ObjectEntity,
    val s3SchemaVersion: String,
)

@JvmInline
@Serializable
value class RequestParametersEntity(
    val sourceIPAddress: String,
)

@Serializable
data class ResponseElementsEntity(
    val xAmzId2: String,
    val xAmzRequestId: String,
)

@Serializable
data class S3EventNotificationRecord(
    val awsRegion: String,
    val eventName: String,
    val eventSource: String,
    val eventTime: Instant,
    val eventVersion: String,
    val requestParameters: RequestParametersEntity,
    val responseElements: ResponseElementsEntity,
    val s3: S3Entity,
    val userIdentity: UserIdentityEntity,
)
