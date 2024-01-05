package dev.jtkt.services.lambda.runtime.events.kinesis.streams

import dev.jtkt.services.lambda.runtime.events.shared.TimeWindow
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

interface KinesisEventRecords {
    val records: List<KinesisEventRecord>
}

@Serializable
data class KinesisTimeWindowEvent(
    val eventSourceArn: String = "",
    val isFinalInvokeForWindow: Boolean = false,
    val isWindowTerminatedEarly: Boolean = false,
    override val records: List<KinesisEventRecord>,
    val shardId: String = "",
    val state: Map<String, String> = emptyMap(),
    val window: TimeWindow = TimeWindow(),
) : KinesisEventRecords

@Serializable
data class KinesisEvent(
    override val records: List<KinesisEventRecord> = emptyList(),
) : KinesisEventRecords

/**
 * This is pretty confusing, but this is how AWS models it.
 * We have KinesisEvent, KinesisEvent.Record, and KinesisEvent.KinesisEventRecord, which is not the same as KinesisEvent.Record
 */
@Serializable
data class KinesisEventRecord(
    val awsRegion: String = "",
    val eventID: String = "",
    val eventName: String = "",
    val eventSource: String = "",
    val eventSourceARN: String = "",
    val eventVersion: String = "",
    val invokeIdentityArn: String = "",
    val kinesis: Record = Record(),
) {

    @Serializable
    data class Record(
        override val approximateArrivalTimestamp: Instant = Clock.System.now(),
        override val data: ByteArray = ByteArray(0),
        override val encryptionType: EncryptionType = EncryptionType.NONE,
        val kinesisSchemaVersion: String = "",
        override val partitionKey: String = "",
        override val sequenceNumber: String = "",
    ) : KinesisRecord
}
