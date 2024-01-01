package dev.jtkt.services.lambda.runtime.events.config

import kotlinx.serialization.Serializable

@Serializable
data class ConfigEvent(
    val version: String = "",
    val invokingEvent: String = "",
    val ruleParameters: String = "",
    val resultToken: String = "",
    val configRuleArn: String = "",
    val configRuleId: String = "",
    val configRuleName: String = "",
    val accountId: String = "",
    val executionRoleArn: String = "",
    val eventLeftScope: Boolean = false,
)