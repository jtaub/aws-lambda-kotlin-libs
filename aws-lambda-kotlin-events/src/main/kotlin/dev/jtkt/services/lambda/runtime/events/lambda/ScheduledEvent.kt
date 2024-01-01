package dev.jtkt.services.lambda.runtime.events.lambda

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class ScheduledEvent(
    val version: String = "",
    val account: String = "",
    val region: String = "",
    val detail: Map<String, String> = mapOf(),
    val detailType: String = "",
    val source: String = "",
    val id: String = "",
    val time: Instant = Clock.System.now(),
    val resources: List<String> = listOf(),
)