package dev.jtkt.services.lambda.runtime.events

import kotlinx.datetime.Clock

internal object TimeUtils {

    fun nowEpochMillis(): Long =
        now().toEpochMilliseconds()

    fun now() =
        Clock.System.now()
}