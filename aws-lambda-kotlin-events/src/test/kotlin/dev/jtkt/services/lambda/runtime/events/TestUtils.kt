package dev.jtkt.services.lambda.runtime.events

import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream

internal object TestUtils {

    inline fun <reified T> Json.decodeFromOutputStream(outputStream: ByteArrayOutputStream) =
        Json.decodeFromString<T>(outputStream.toString(Charsets.UTF_8))
}