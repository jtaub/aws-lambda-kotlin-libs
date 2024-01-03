package dev.jtkt.services.lambda.runtime.events.dynamodb

import kotlinx.serialization.Serializable

interface DynamoDbRecords {
    val records: List<DynamoDbStreamRecord>
}

/**
 * Represents an Amazon DynamoDB event
 */
@Serializable
data class DynamoDbEvent(
    override val records: List<DynamoDbStreamRecord> = emptyList(),
) : DynamoDbRecords

/**
 * The unit of data of an Amazon DynamoDB event.
 *
 * Most of the fields here are redundant with [Record]. Ideally, we would make both these classes
 * implement the same interface, and then [DynamoDbStreamRecord] can delegate to [Record].
 * But, in the interest of keeping the format consistent with DynamoDb's actual message format,
 * we will duplicate all the fields here.
 */
@Serializable
data class DynamoDbStreamRecord(
    val eventSourceARN: String = "",
    val eventID: String = "",
    val eventName: EventName = EventName.INSERT,
    val eventVersion: String = "",
    val eventSource: String = "aws:dynamodb",
    val awsRegion: String = "",
    val userIdentity: Identity = Identity(),
    val dynamodb: Record = Record(
        awsRegion = awsRegion,
        eventID = eventID,
        eventName = eventName,
        eventSource = eventSource,
        eventVersion = eventVersion,
        userIdentity = userIdentity,
    ),
)
