package dev.jtkt.services.lambda.runtime.events.kafka

import kotlinx.serialization.Serializable

@Serializable
data class KafkaEvent(
    val bootstrapServers: String = "",
    val eventSource: String = "",
    val eventSourceArn: String = "",
    val records: Map<String, List<KafkaEventRecord>> = emptyMap(),
)

@Serializable
data class KafkaEventRecord(
    val headers: List<Map<String, ByteArray>> = emptyList(),
    val key: String = "",
    val offset: Long = 0L,
    val partition: Int = 0,
    val timestamp: Long = 0L,
    val timestampType: String = "",
    val topic: String = "",
    val value: String = "",
)

@Serializable
data class TopicPartition(
    val partition: Int = 0,
    val topic: String = "",
) {
    override fun toString(): String = "$topic-$partition"
}
