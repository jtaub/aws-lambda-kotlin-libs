package dev.jtkt.services.lambda.runtime.events.dynamodb

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable


@Serializable
data class StreamRecord(
    val approximateCreationDateTime: Instant = Clock.System.now(),
    val keys: Map<String, AttributeValue> = emptyMap(),
    val newImage: Map<String, AttributeValue> = emptyMap(),
    val oldImage: Map<String, AttributeValue> = emptyMap(),
    val sequenceNumber: String = "",
    val sizeBytes: Long? = null,
    val streamViewType: StreamViewType = StreamViewType.NEW_AND_OLD_IMAGES,
)
