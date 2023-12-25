package dev.jtkt.services.lambda.runtime.events.dynamodb

import kotlinx.serialization.Serializable

/**
 * Represents an Amazon Dynamodb event when using time windows.
 */
@Serializable
data class DynamodbTimeWindowEvent(
    override val records: List<DynamoDbStreamRecord> = emptyList(),
    val window: TimeWindow = TimeWindow(),
    val state: Map<String, String> = emptyMap(),
    val shardId: String = "",
    val eventSourceArn: String = "",
    val isFinalInvokeForWindow: Boolean = false,
    val isWindowTerminatedEarly: Boolean = false,
) : DynamoDbRecords
