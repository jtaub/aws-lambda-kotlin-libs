package dev.jtkt.services.lambda.runtime.events.apigw.v2.http

import dev.jtkt.services.lambda.runtime.events.apigw.HttpMethod
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals


class ApiGatewayV2HttpEventTest {

    private val serializer = Json {
        ignoreUnknownKeys = true
    }

    @Test
    fun deserialize() {
        // Given
        val default = "foo"
        val json = """
            {
              "version": "2.0",
              "routeKey": "$default",
              "rawPath": "/my/path",
              "rawQueryString": "parameter1=value1&parameter1=value2&parameter2=value",
              "cookies": [
                "cookie1",
                "cookie2"
              ],
              "headers": {
                "header1": "value1",
                "header2": "value1,value2"
              },
              "queryStringParameters": {
                "parameter1": "value1,value2",
                "parameter2": "value"
              },
              "requestContext": {
                "accountId": "123456789012",
                "apiId": "api-id",
                "authentication": {
                  "clientCert": {
                    "clientCertPem": "CERT_CONTENT",
                    "subjectDN": "www.example.com",
                    "issuerDN": "Example issuer",
                    "serialNumber": "a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1",
                    "validity": {
                      "notBefore": "May 28 12:30:02 2019 GMT",
                      "notAfter": "Aug  5 09:36:04 2021 GMT"
                    }
                  }
                },
                "authorizer": {
                  "jwt": {
                    "claims": {
                      "claim1": "value1",
                      "claim2": "value2"
                    },
                    "scopes": [
                      "scope1",
                      "scope2"
                    ]
                  }
                },
                "domainName": "id.execute-api.us-east-1.amazonaws.com",
                "domainPrefix": "id",
                "http": {
                  "method": "POST",
                  "path": "/my/path",
                  "protocol": "HTTP/1.1",
                  "sourceIp": "192.0.2.1",
                  "userAgent": "agent"
                },
                "requestId": "id",
                "routeKey": "$default",
                "stage": "$default",
                "time": "12/Mar/2020:19:03:58 +0000",
                "timeEpoch": 1583348638390
              },
              "body": "Hello from Lambda",
              "pathParameters": {
                "parameter1": "value1"
              },
              "isBase64Encoded": false,
              "stageVariables": {
                "stageVariable1": "value1",
                "stageVariable2": "value2"
              }
            }
        """.trimIndent()

        // When
        val actual = serializer.decodeFromString<ApiGatewayV2HttpEvent>(json)

        // Then
        val expected = ApiGatewayV2HttpEvent(
            version = "2.0",
            routeKey = default,
            rawPath = "/my/path",
            rawQueryString = "parameter1=value1&parameter1=value2&parameter2=value",
            cookies = listOf("cookie1", "cookie2"),
            headers = mapOf("header1" to "value1", "header2" to "value1,value2"),
            queryStringParameters = mapOf("parameter1" to "value1,value2", "parameter2" to "value"),
            requestContext = HttpRequestContext(
                accountId = "123456789012",
                apiId = "api-id",
//                authentication = Authentication(
//                    clientCert = ClientCert(
//                        clientCertPem = "CERT_CONTENT",
//                        subjectDN = "www.example.com",
//                        issuerDN = "Example issuer",
//                        serialNumber = "a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1:a1",
//                        validity = Validity(
//                            notBefore = "May 28 12:30:02 2019 GMT",
//                            notAfter = "Aug  5 09:36:04 2021 GMT"
//                        )
//                    )
//                ),
//                authorizer = Authorizer(
//                    jwt = Jwt(
//                        claims = mapOf("claim1" to "value1", "claim2" to "value2"),
//                        scopes = listOf("scope1", "scope2")
//                    )
//                ),
                domainName = "id.execute-api.us-east-1.amazonaws.com",
                domainPrefix = "id",
                http = Http(
                    method = HttpMethod.POST,
                    path = "/my/path",
                    protocol = "HTTP/1.1",
                    sourceIp = "192.0.2.1",
                    userAgent = "agent"
                ),
                requestId = "id",
                routeKey = default,
                stage = default,
                timeEpoch = 1583348638390L,
            ),
            body = "Hello from Lambda",
            pathParameters = mapOf("parameter1" to "value1"),
            isBase64Encoded = false,
            stageVariables = mapOf("stageVariable1" to "value1", "stageVariable2" to "value2")
        )

        assertEquals(expected, actual)
    }
}