package dev.jtkt.services.lambda.runtime.events.mq

import kotlinx.serialization.Serializable

@Serializable
data class RabbitMqEvent(
    val eventSource: String = "",
    val eventSourceArn: String = "",
    val rmqMessagesByQueue: Map<String, List<RabbitMessage>> = emptyMap(),
) {
    @Serializable
    data class RabbitMessage(
        val basicProperties: BasicProperties = BasicProperties(),
        val data: String = "",
        val redelivered: Boolean = false,
    )

    @Serializable
    data class BasicProperties(
        val appId: String = "",
        val bodySize: Int = 0,
        val clusterId: String = "",
        val contentEncoding: String = "",
        val contentType: String = "",
        val correlationId: String = "",
        val deliveryMode: Int = 0,
        val expiration: Int = 0,
        val headers: Map<String, String> = emptyMap(),
        val messageId: String = "",
        val priority: Int = 0,
        val replyTo: String = "",
        val timestamp: String = "",
        val type: String = "",
        val userId: String = "",
    )
}
