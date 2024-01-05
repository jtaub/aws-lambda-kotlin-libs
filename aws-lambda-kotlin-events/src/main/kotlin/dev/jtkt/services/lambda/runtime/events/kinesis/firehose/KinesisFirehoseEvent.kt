package dev.jtkt.services.lambda.runtime.events.kinesis.firehose

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class KinesisFirehoseEvent(
    val invocationId: String = "",
    val deliveryStreamArn: String = "",
    val region: String = "",
    val records: List<Record> = emptyList(),
) {
    @Serializable
    data class Record(
        val approximateArrivalEpoch: Instant = Clock.System.now(),
        val data: ByteArray = ByteArray(0),
        val kinesisRecordMetadata: Map<String, String> = emptyMap(),
        val recordId: String = "",
    )
}
