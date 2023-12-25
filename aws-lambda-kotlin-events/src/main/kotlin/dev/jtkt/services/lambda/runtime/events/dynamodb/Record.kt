package dev.jtkt.services.lambda.runtime.events.dynamodb

import kotlinx.serialization.Serializable

@Serializable
data class Record(
    val eventID: String = "",
    val eventName: EventName = EventName.INSERT,
    val eventVersion: String = "",
    val eventSource: String = "aws:dynamodb",
    val awsRegion: String = "",
    val dynamodb: StreamRecord = StreamRecord(),
    val userIdentity: Identity = Identity(),
)

enum class EventName {
    INSERT, MODIFY, REMOVE
}
