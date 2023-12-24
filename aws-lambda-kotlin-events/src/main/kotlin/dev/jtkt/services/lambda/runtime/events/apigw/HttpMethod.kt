package dev.jtkt.services.lambda.runtime.events.apigw

import kotlinx.serialization.Serializable

@Serializable
enum class HttpMethod {
    GET, PUT, POST, DELETE, HEAD, OPTIONS,
}
