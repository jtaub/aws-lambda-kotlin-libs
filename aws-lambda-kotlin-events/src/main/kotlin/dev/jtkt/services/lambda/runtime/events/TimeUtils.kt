package dev.jtkt.services.lambda.runtime.events

import kotlinx.datetime.Clock

internal object TimeUtils {

    fun nowEpochMillis(): Long =
        Clock.System.now().toEpochMilliseconds()
}