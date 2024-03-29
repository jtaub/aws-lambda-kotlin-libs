package dev.jtkt.services.lambda.runtime.events.sns

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class SnsEvent(
    val records: List<SnsRecord> = emptyList(),
) {

    @Serializable
    data class SnsRecord(
        val eventSource: String = "aws:sns",
        val eventSubscriptionArn: String = "",
        val eventVersion: String = "1.0",
        val sns: Sns = Sns(),
    )

    @Serializable
    data class Sns(
        val message: String = "",
        val messageAttributes: Map<String, MessageAttribute> = emptyMap(),
        val messageId: String = "",
        val signature: String = "",
        val signatureVersion: String = "1",
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
