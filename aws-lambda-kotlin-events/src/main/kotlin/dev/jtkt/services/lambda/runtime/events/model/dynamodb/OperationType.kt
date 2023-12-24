package dev.jtkt.services.lambda.runtime.events.model.dynamodb

import kotlinx.serialization.Serializable

@Serializable
enum class OperationType(val value: String) {
    INSERT("INSERT"),
    MODIFY("MODIFY"),
    REMOVE("REMOVE");
}
