package dev.jtkt.services.lambda.runtime

import org.junit.jupiter.api.Test

class LambdaLoggerTest {
    private val candidate = PrintLogger

    @Test
    fun trace() = candidate.trace { "hello world" }

    @Test
    fun debug() = candidate.debug { "hello world" }

    @Test
    fun info() = candidate.info { "hello world" }

    @Test
    fun warn() = candidate.warn { "hello world" }

    @Test
    fun error() = candidate.error { "hello world" }

    @Test
    fun fatal() = candidate.fatal { "hello world" }
}