package dev.jtkt.services.lambda.runtime.events.s3

import kotlinx.serialization.Serializable

@Serializable
data class S3BatchResponse(
    val invocationSchemaVersion: String = "",
    val treatMissingKeysAs: ResultCode = ResultCode.Succeeded,
    val invocationId: String = "",
    val results: List<Result> = emptyList(),
) {
    @Serializable
    data class Result(
        val taskId: String = "",
        val resultCode: ResultCode = ResultCode.Succeeded,
        val resultString: String = "",
    )

    enum class ResultCode {
        Succeeded,
        TemporaryFailure,
        PermanentFailure
    }

    companion object {
        fun fromS3BatchEvent(s3BatchEvent: S3BatchEvent) = S3BatchResponse(
            invocationSchemaVersion = s3BatchEvent.invocationSchemaVersion,
            invocationId = s3BatchEvent.invocationId
        )
    }
}
