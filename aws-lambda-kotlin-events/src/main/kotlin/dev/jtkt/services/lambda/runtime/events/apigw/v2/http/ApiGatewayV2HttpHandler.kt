package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.Context
import dev.jtkt.services.lambda.runtime.RequestHandler
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.InputStream
import java.io.OutputStream


val apiGatewayHandler = RequestHandler<ApiGatewayV2HttpEvent, ApiGatewayV2HttpResponse> { request, context ->
    ApiGatewayV2HttpResponse(body = request.body.uppercase())
}