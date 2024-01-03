package dev.jtkt.services.lambda.runtime.events.s3

import kotlinx.serialization.Serializable

@Serializable
data class S3BatchEvent(
    val invocationSchemaVersion: String = "",
    val invocationId: String = "",
    val job: Job = Job(),
    val tasks: List<Task> = emptyList(),
) {
    @Serializable
    data class Job(
        val id: String = "",
    )

    @Serializable
    data class Task(
        val taskId: String = "",
        val s3Key: String = "",
        val s3VersionId: String = "",
        val s3BucketArn: String = "",
    )
}
