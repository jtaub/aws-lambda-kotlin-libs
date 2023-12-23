package dev.jtkt.services.lambda.runtime.events

import kotlinx.serialization.Serializable

sealed interface Authorizer

interface RequestAuthorizer : Authorizer
interface TokenAuthorizer : Authorizer

@Serializable
data class JWT(
    val claims: Map<String, String> = emptyMap(),
    val scopes: List<String> = emptyList(),
) : TokenAuthorizer
