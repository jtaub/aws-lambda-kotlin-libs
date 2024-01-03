package dev.jtkt.services.lambda.runtime.events.cloudwatch

import kotlinx.serialization.Serializable

@Serializable
data class CloudWatchLogsEvent(
    val awsLogs: AWSLogs = AWSLogs(),
) {
    @Serializable
    data class AWSLogs(val data: String = "")
}