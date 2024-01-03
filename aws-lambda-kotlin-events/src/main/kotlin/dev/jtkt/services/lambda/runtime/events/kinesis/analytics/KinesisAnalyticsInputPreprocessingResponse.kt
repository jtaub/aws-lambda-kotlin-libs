package dev.jtkt.services.lambda.runtime.events.kinesis.analytics

import kotlinx.serialization.Serializable

@Serializable
data class KinesisAnalyticsInputPreprocessingResponse(
    val records: List<Record> = emptyList(),
) {
    @Serializable
    data class Record(
        val data: ByteArray = ByteArray(0),
        val recordId: String = "",
        val result: Result = Result.Ok,
    )

    enum class Result {
        Ok,
        ProcessingFailed,
        Dropped
    }
}
