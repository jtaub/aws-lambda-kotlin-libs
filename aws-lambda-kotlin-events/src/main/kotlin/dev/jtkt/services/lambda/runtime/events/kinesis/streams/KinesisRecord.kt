package dev.jtkt.services.lambda.runtime.events.kinesis.streams

import kotlinx.datetime.Instant

interface KinesisRecord {
    val approximateArrivalTimestamp: Instant
    val data: ByteArray
    val encryptionType: EncryptionType
    val partitionKey: String
    val sequenceNumber: String
}
