package dev.jtkt.services.lambda.runtime.events.sqs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SqsEvent(
    @SerialName("Records") val records: List<SqsMessage> = emptyList(),
)

@Serializable
data class SqsMessage(
    val attributes: Map<String, String> = emptyMap(),
    val awsRegion: String = "",
    val body: String = "",
    val eventSource: String = "",
    @SerialName("eventSourceARN") val eventSourceArn: String = "",
    val md5OfBody: String = "",
    val md5OfMessageAttributes: String = "",
    val messageAttributes: Map<String, MessageAttribute> = emptyMap(),
    val messageId: String = "",
    val receiptHandle: String = "",
)

@Serializable
data class MessageAttribute(
    val binaryListValues: List<ByteArray> = emptyList(),
    val binaryValue: ByteArray = byteArrayOf(),
    val dataType: String = "",
    val stringListValues: List<String> = emptyList(),
    val stringValue: String = "",
)
