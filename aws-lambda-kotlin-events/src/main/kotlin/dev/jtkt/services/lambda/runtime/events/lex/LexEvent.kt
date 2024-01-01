package dev.jtkt.services.lambda.runtime.events.lex

import kotlinx.serialization.Serializable

@Serializable
data class LexEvent(
    val messageVersion: String = "",
    val invocationSource: String = "",
    val userId: String = "",
    val sessionAttributes: Map<String, String> = mapOf(),
    val outputDialogMode: String = "",
    val currentIntent: CurrentIntent = CurrentIntent(),
    val bot: Bot = Bot(),
) {
    @Serializable
    data class Bot(
        val name: String = "",
        val alias: String = "",
        val version: String = "",
    )

    @Serializable
    data class CurrentIntent(
        val name: String = "",
        val slots: Map<String, String> = mapOf(),
        val confirmationStatus: String = "",
    )
}