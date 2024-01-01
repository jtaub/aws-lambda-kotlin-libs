package dev.jtkt.services.lambda.runtime.events.connect

import kotlinx.serialization.Serializable

@Serializable
data class ConnectEvent(
    val details: Details = Details(),
    val name: String = "",
) {
    @Serializable
    data class Details(
        val contactData: ContactData = ContactData(),
        val parameters: Map<String, String> = mapOf(),
    )

    @Serializable
    data class ContactData(
        val attributes: Map<String, String> = mapOf(),
        val channel: String = "",
        val contactId: String = "",
        val customerEndpoint: CustomerEndpoint = CustomerEndpoint(),
        val initialContactId: String = "",
        val initiationMethod: String = "",
        val instanceArn: String = "",
        val previousContactId: String = "",
        val queue: String = "",
        val systemEndpoint: SystemEndpoint = SystemEndpoint(),
    )

    @Serializable
    data class CustomerEndpoint(
        val address: String = "",
        val type: String = "",
    )

    @Serializable
    data class SystemEndpoint(
        val address: String = "",
        val type: String = "",
    )
}