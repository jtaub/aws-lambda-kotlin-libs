package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.newLambdaHandler


val apiGatewayHandler = newLambdaHandler<ApiGatewayV2HttpEvent, ApiGatewayV2HttpResponse> { request, context ->
    ApiGatewayV2HttpResponse(body = request.body.uppercase())
}