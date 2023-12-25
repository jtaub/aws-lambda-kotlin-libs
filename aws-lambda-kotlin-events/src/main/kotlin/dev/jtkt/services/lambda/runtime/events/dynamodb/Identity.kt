package dev.jtkt.services.lambda.runtime.events.dynamodb

import kotlinx.serialization.Serializable

@Serializable
data class Identity(
    val principalId: String = "dynamodb.amazonaws.com",
    val type: String = "Service",
)
