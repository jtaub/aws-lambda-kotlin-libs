package dev.jtkt.services.lambda.runtime.events.mq

import kotlinx.serialization.Serializable

@Serializable
data class ActiveMqEvent(
    val eventSource: String = "",
    val eventSourceArn: String = "",
    val messages: List<ActiveMqMessage> = emptyList(),
) {
    @Serializable
    data class ActiveMqMessage(
        val brokerInTime: Long = 0L,
        val brokerOutTime: Long = 0L,
        val correlationID: String = "",
        val data: String = "",
        val deliveryMode: Int = 0,
        val destination: Destination = Destination(),
        val expiration: Long = 0L,
        val messageID: String = "",
        val messageType: String = "",
        val priority: Int = 0,
        val properties: Map<String, String> = emptyMap(),
        val redelivered: Boolean = false,
        val replyTo: String = "",
        val timestamp: Long = 0L,
        val type: String = "",
    )

    @Serializable
    data class Destination(
        val physicalName: String = "",
    )
}
