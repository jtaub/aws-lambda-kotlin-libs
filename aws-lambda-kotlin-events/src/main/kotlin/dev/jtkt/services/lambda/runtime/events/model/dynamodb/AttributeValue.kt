package dev.jtkt.services.lambda.runtime.events.model.dynamodb

import kotlinx.serialization.Serializable

@Serializable
data class AttributeValue(
    val s: String? = null, // String type
    val n: String? = null, // Number type
    val b: String? = null, // Binary type
    val ss: List<String> = emptyList(), // String Set type
    val ns: List<String> = emptyList(), // Number Set type
    val bs: List<String> = emptyList(), // Binary Set type
    val m: Map<String, AttributeValue> = emptyMap(), // Map type
    val l: List<AttributeValue> = emptyList(), // List type
    val nullValue: Boolean? = null, // NULL type
    val bool: Boolean? = null, // BOOL type
)
