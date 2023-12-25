package dev.jtkt.services.lambda.runtime.events.sns

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class SnsEvent(
    val records: List<SnsRecord> = emptyList(),
) {

    @Serializable
    data class SnsRecord(
        val eventSource: String = "",
        val eventSubscriptionArn: String = "",
        val eventVersion: String = "",
        val sns: Sns = Sns(),
    )

    @Serializable
    data class Sns(
        val message: String = "",
        val messageAttributes: Map<String, MessageAttribute> = emptyMap(),
        val messageId: String = "",
        val signature: String = "",
        val signatureVersion: String = "",
        val signingCertUrl: String = "",
        val subject: String = "",
        val timestamp: Instant = Clock.System.now(),
        val topicArn: String = "",
        val type: String = "",
        val unsubscribeUrl: String = "",
    )

    @Serializable
    data class MessageAttribute(
        val type: String = "",
        val value: String = "",
    )
}
