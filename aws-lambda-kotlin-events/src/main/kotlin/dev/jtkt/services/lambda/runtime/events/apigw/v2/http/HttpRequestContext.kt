package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.events.TimeUtils.nowEpochMillis
import dev.jtkt.services.lambda.runtime.events.apigw.v2.RequestContext
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class HttpRequestContext(
    override val accountId: String = "",
    override val apiId: String = "",
    override val domainName: String = "",
    val domainPrefix: String = "",
    val http: Http = Http(),
    override val requestId: String = "",
    override val routeKey: String = "",
    override val stage: String = "",
    override val timeEpoch: Long = nowEpochMillis(),
) : RequestContext
