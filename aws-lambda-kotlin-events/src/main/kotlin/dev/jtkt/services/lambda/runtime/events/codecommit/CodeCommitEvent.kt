package dev.jtkt.services.lambda.runtime.events.codecommit

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class CodeCommitEvent(
    val records: List<Record> = emptyList(),
) {
    @Serializable
    data class Record(
        val eventId: String = "",
        val eventVersion: String = "",
        val eventTime: Instant = Clock.System.now(),
        val eventTriggerName: String = "",
        val eventPartNumber: Int = 0,
        val codeCommit: CodeCommit = CodeCommit(),
        val eventName: String = "",
        val eventTriggerConfigId: String = "",
        val eventSourceArn: String = "",
        val userIdentityArn: String = "",
        val eventSource: String = "",
        val awsRegion: String = "",
        val customData: String = "",
        val eventTotalParts: Int = 0,
    )

    @Serializable
    data class CodeCommit(val references: List<Reference> = emptyList())

    @Serializable
    data class Reference(
        val commit: String = "",
        val ref: String = "",
        val created: Boolean = false,
    )
}