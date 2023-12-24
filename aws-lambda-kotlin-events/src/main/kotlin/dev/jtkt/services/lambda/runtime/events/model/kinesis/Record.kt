package dev.jtkt.services.lambda.runtime.events.model.kinesis

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class Record(
    val sequenceNumber: String,
    val partitionKey: String,
    val data: ByteArray = byteArrayOf(),
    val approximateArrivalTimestamp: Instant = Clock.System.now(),
    val encryptionType: EncryptionType = EncryptionType.NONE,
)
