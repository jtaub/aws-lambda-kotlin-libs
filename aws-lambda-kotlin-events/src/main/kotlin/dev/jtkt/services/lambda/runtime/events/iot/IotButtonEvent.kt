package dev.jtkt.services.lambda.runtime.events.iot

import kotlinx.serialization.Serializable

@Serializable
data class IotButtonEvent(
    val serialNumber: String = "",
    val clickType: String = "",
    val batteryVoltage: String = "",
)