package dev.jtkt.services.lambda.runtime.events.kinesis

import kotlinx.serialization.Serializable


@Serializable
@JvmInline
value class BatchItemFailure(
    val itemIdentifier: String = "",
)

interface BatchItemFailures {
    val batchItemFailures: List<BatchItemFailure>
}

@Serializable
@JvmInline
value class StreamsEventResponse(
    override val batchItemFailures: List<BatchItemFailure> = listOf(),
) : BatchItemFailures

@Serializable
data class TimeWindowEventResponse(
    val state: Map<String, String> = mapOf(),
    override val batchItemFailures: List<BatchItemFailure> = listOf(),
) : BatchItemFailures