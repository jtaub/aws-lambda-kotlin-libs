package dev.jtkt.services.lambda.runtime.events.model.dynamodb

import kotlinx.serialization.Serializable

@Serializable
data class Record(
    val eventID: String = "",
    val eventName: String = "", // "INSERT", "MODIFY", "REMOVE"
    val eventVersion: String = "",
    val eventSource: String = "aws:dynamodb",
    val awsRegion: String = "",
    val dynamodb: StreamRecord = StreamRecord(),
    val userIdentity: Identity = Identity(),
)
