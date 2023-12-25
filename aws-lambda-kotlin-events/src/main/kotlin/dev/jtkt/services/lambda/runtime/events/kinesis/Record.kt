package dev.jtkt.services.lambda.runtime.events.kinesis

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class Record(
    val approximateArrivalTimestamp: Instant = Clock.System.now(),
    val data: ByteArray = ByteArray(0),
    val encryptionType: EncryptionType = EncryptionType.NONE,
    val partitionKey: String,
    val sequenceNumber: String,
)
