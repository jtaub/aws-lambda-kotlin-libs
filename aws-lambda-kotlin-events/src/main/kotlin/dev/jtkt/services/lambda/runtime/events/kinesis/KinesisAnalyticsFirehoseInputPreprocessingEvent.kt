package dev.jtkt.services.lambda.runtime.events.kinesis

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class KinesisAnalyticsFirehoseInputPreprocessingEvent(
    val applicationArn: String = "",
    val invocationId: String = "",
    val records: List<Record> = emptyList(),
    val streamArn: String = "",
) {
    @Serializable
    data class Record(
        val recordId: String = "",
        val kinesisFirehoseRecordMetadata: KinesisFirehoseRecordMetadata = KinesisFirehoseRecordMetadata(),
        val data: ByteArray = ByteArray(0),
    )

    @JvmInline
    @Serializable
    value class KinesisFirehoseRecordMetadata(
        val approximateArrivalTimestamp: Instant = Clock.System.now(),
    )
}
