package dev.jtkt.services.lambda.runtime.events.s3

import dev.jtkt.services.lambda.runtime.events.TestUtils.decodeFromOutputStream
import dev.jtkt.services.lambda.runtime.newLambdaHandler
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalSerializationApi
class S3BatchEventTest {

    private val candidate = newLambdaHandler<S3BatchEvent, S3BatchResponse> { event, _ ->
        S3BatchResponse(
            invocationId = event.invocationId,
            invocationSchemaVersion = event.invocationSchemaVersion,
            results = event.tasks.map { task ->
                S3BatchResponse.Result(
                    taskId = task.taskId,
                    resultString = "${task.s3BucketArn}:${task.s3Key}"
                )
            },
        )
    }

    @Test
    fun simpleTest() {
        // Given
        val input = """
            {
            "invocationSchemaVersion": "1.0",
            "invocationId": "YXNkbGZqYWRmaiBhc2RmdW9hZHNmZGpmaGFzbGtkaGZza2RmaAo",
            "job": {
                "id": "f3cc4f60-61f6-4a2b-8a21-d07600c373ce"
            },
            "tasks": [
                {
                    "taskId": "dGFza2lkZ29lc2hlcmUK",
                    "s3Key": "customerImage1.jpg",
                    "s3VersionId": "1",
                    "s3BucketArn": "arn:aws:s3:::examplebucket"
                }
            ]  
            }
        """.trimIndent()

        // When
        val outputStream = ByteArrayOutputStream()
        candidate(input.byteInputStream(), outputStream, null)

        // Then
        val actual = Json.decodeFromOutputStream<S3BatchResponse>(outputStream)
        val expected = S3BatchResponse(
            invocationSchemaVersion = "1.0",
            invocationId = "YXNkbGZqYWRmaiBhc2RmdW9hZHNmZGpmaGFzbGtkaGZza2RmaAo",
            results = listOf(
                S3BatchResponse.Result(
                    taskId = "dGFza2lkZ29lc2hlcmUK",
                    resultString = "arn:aws:s3:::examplebucket:customerImage1.jpg"
                )
            )
        )
        assertEquals(expected, actual)
    }
}
