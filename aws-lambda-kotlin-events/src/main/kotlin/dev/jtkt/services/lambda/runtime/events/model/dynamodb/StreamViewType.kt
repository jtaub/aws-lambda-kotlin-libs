package dev.jtkt.services.lambda.runtime.events.model.dynamodb

import kotlinx.serialization.Serializable

@Serializable
enum class StreamViewType(val value: String) {
    NEW_AND_OLD_IMAGES("NEW_AND_OLD_IMAGES"),
    KEYS_ONLY("KEYS_ONLY"),
    NEW_IMAGE("NEW_IMAGE"),
    OLD_IMAGE("OLD_IMAGE"),
}
