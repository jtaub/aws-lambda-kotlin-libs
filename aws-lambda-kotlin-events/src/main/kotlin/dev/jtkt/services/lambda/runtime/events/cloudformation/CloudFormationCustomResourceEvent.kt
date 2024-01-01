package dev.jtkt.services.lambda.runtime.events.cloudformation

import kotlinx.serialization.Serializable

@Serializable
data class CloudFormationCustomResourceEvent(
    val requestType: String = "",
    val serviceToken: String = "",
    val responseUrl: String = "",
    val stackId: String = "",
    val requestId: String = "",
    val logicalResourceId: String = "",
    val physicalResourceId: String = "",
    val resourceType: String = "",
    val resourceProperties: Map<String, String> = emptyMap(),
    val oldResourceProperties: Map<String, String> = emptyMap(),
)