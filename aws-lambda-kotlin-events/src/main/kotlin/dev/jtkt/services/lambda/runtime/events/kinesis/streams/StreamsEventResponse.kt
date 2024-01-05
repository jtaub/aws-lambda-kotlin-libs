package dev.jtkt.services.lambda.runtime.events.kinesis.streams

import kotlinx.serialization.Serializable


@Serializable
data class BatchItemFailure(
    val itemIdentifier: String = "",
)

interface BatchItemFailures {
    val batchItemFailures: List<BatchItemFailure>
}

@Serializable
data class StreamsEventResponse(
    override val batchItemFailures: List<BatchItemFailure> = listOf(),
) : BatchItemFailures

@Serializable
data class TimeWindowEventResponse(
    val state: Map<String, String> = mapOf(),
    override val batchItemFailures: List<BatchItemFailure> = listOf(),
) : BatchItemFailures