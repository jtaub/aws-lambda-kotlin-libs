package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import kotlinx.serialization.Serializable

@Serializable
data class Http(
    val method: HttpMethod = HttpMethod.GET,
    val path: String = "/",
    val protocol: String = "",
    val sourceIp: String = "",
    val userAgent: String = "",
)
