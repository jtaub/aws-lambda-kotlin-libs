package dev.jtkt.services.lambda.runtime.events.kinesis

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class KinesisAnalyticsStreamsInputPreprocessingEvent(
    val applicationArn: String = "",
    val invocationId: String = "",
    val records: List<Record> = emptyList(),
    val streamArn: String = "",
) {
    @Serializable
    data class Record(
        val data: ByteArray = ByteArray(0),
        val kinesisStreamRecordMetadata: KinesisStreamRecordMetadata = KinesisStreamRecordMetadata(),
        val recordId: String = "",
    )

    @Serializable
    data class KinesisStreamRecordMetadata(
        val approximateArrivalTimestamp: Instant = Clock.System.now(),
        val partitionKey: String = "",
        val sequenceNumber: String = "",
        val shardId: String = "",
    )
}
