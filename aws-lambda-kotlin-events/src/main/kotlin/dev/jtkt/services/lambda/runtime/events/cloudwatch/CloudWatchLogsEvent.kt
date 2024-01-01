package dev.jtkt.services.lambda.runtime.events.cloudwatch

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class CloudWatchLogsEvent(
    val awsLogs: AWSLogs = AWSLogs(),
) {
    @Serializable
    @JvmInline
    value class AWSLogs(val data: String = "")
}