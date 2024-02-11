package dev.jtkt.services.lambda.runtime

import kotlinx.serialization.json.Json

data class SerializationOptions(
    val inputFormat: Json = jsonFormatDefaults,
    val outputFormat: Json = jsonFormatDefaults,
) {

    companion object {
        private val jsonFormatDefaults = Json {
            coerceInputValues = true
            encodeDefaults = true
            ignoreUnknownKeys = true
            useAlternativeNames = false
        }

        val DEFAULT = SerializationOptions()
    }
}
