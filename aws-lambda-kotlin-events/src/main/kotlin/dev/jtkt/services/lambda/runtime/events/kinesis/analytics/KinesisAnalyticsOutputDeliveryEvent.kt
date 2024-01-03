package dev.jtkt.services.lambda.runtime.events.kinesis.analytics

import kotlinx.serialization.Serializable

@Serializable
data class KinesisAnalyticsOutputDeliveryEvent(
    val applicationArn: String = "",
    val invocationId: String = "",
    val records: List<Record> = emptyList(),
) {
    @Serializable
    data class Record(
        val data: ByteArray = ByteArray(0),
        val lambdaDeliveryRecordMetadata: LambdaDeliveryRecordMetadata = LambdaDeliveryRecordMetadata(0L),
        val recordId: String = "",
    )

    @Serializable
    data class LambdaDeliveryRecordMetadata(val retryHint: Long = 0)
}
