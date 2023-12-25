package dev.jtkt.services.lambda.runtime.events.shared

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TimeWindow(
    val start: Instant = Clock.System.now(),
    val end: Instant = Clock.System.now(),
)
