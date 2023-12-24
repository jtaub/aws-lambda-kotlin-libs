package dev.jtkt.services.lambda.runtime.events.model.dynamodb

import kotlinx.serialization.Serializable

@Serializable
data class Identity(
    val principalId: String = "dynamodb.amazonaws.com",
    val type: String = "Service",
)
