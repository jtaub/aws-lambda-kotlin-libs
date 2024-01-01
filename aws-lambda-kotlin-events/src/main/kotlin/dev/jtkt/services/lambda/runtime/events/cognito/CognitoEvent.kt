package dev.jtkt.services.lambda.runtime.events.cognito

import kotlinx.serialization.Serializable

@Serializable
data class CognitoEvent(
    val region: String = "",
    val datasetRecords: Map<String, DatasetRecord> = emptyMap(),
    val identityPoolId: String = "",
    val identityId: String = "",
    val datasetName: String = "",
    val eventType: String = "",
    val version: Int = 0,
) {
    @Serializable
    data class DatasetRecord(
        val oldValue: String = "",
        val newValue: String = "",
        val op: String = "",
    )
}