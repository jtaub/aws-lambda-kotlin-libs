package dev.jtkt.services.lambda.runtime.events.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TimeWindow(
    val start: Instant,
    val end: Instant,
)
