package dev.jtkt.services.lambda.runtime.events.kinesis.analytics

import kotlinx.serialization.Serializable

@Serializable
data class KinesisAnalyticsOutputDeliveryResponse(
    val records: List<Record> = emptyList(),
) {
    @Serializable
    data class Record(
        val recordId: String = "",
        val result: Result = Result.Ok,
    )

    enum class Result {
        Ok,
        DeliveryFailed
    }
}
