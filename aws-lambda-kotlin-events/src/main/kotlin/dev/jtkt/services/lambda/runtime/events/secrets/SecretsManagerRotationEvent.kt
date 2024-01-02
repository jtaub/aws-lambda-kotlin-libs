package dev.jtkt.services.lambda.runtime.events.secrets


import kotlinx.serialization.Serializable

@Serializable
data class SecretsManagerRotationEvent(
    val step: String = "",
    val secretId: String = "",
    val clientRequestToken: String = "",
)