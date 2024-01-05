package dev.jtkt.services.lambda.runtime.events

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy

/**
 * Various AWS services (like SNS) serialize their json keys in TitleCase, instead of camelCase.
 * We want to use camelCase in Kotlin, though. Use this naming strategy with your [Json] instance if you are
 * using a service which sends events in TitleCase
 */
@ExperimentalSerializationApi
data object TitleCase : JsonNamingStrategy {
    override fun serialNameForJson(descriptor: SerialDescriptor, elementIndex: Int, serialName: String) =
        serialName.first().uppercase() + serialName.substring(1)
}

@ExperimentalSerializationApi
val titleCaseSerializer = Json {
    namingStrategy = TitleCase
}