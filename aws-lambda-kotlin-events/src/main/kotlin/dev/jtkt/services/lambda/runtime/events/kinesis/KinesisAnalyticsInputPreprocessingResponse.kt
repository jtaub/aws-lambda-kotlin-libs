package dev.jtkt.services.lambda.runtime.events.kinesis

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class KinesisAnalyticsInputPreprocessingResponse(
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
