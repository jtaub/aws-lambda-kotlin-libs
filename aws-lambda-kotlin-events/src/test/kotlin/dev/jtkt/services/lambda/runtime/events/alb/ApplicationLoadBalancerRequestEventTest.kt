package dev.jtkt.services.lambda.runtime.events.alb

import dev.jtkt.services.lambda.runtime.events.TestUtils.decodeFromOutputStream
import dev.jtkt.services.lambda.runtime.newLambdaHandler
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import kotlin.test.assertEquals

class ApplicationLoadBalancerRequestEventTest {

    private val candidate = newLambdaHandler { event: ApplicationLoadBalancerRequestEvent ->
        ApplicationLoadBalancerResponseEvent(body = "Hello, ${event.body}!")
    }

    @Test
    fun simpleTest() {
        // Given
        val input = """
            {
                "requestContext": {
                    "elb": {
                        "targetGroupArn": "arn:aws:elasticloadbalancing:us-east-1:123456789012:targetgroup/lambda-279XGJDqGZ5rsrHC2Fjr/49e9d65c45c6791a"
                    }
                },
                "httpMethod": "GET",
                "path": "/lambda",
                "queryStringParameters": {
                    "query": "1234ABCD"
                },
                "headers": {
                    "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
                    "accept-encoding": "gzip",
                    "accept-language": "en-US,en;q=0.9",
                    "connection": "keep-alive",
                    "host": "lambda-alb-123578498.us-east-1.elb.amazonaws.com",
                    "upgrade-insecure-requests": "1",
                    "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36",
                    "x-amzn-trace-id": "Root=1-5c536348-3d683b8b04734faae651f476",
                    "x-forwarded-for": "72.12.164.125",
                    "x-forwarded-port": "80",
                    "x-forwarded-proto": "http",
                    "x-imforwards": "20"
                },
                "body": "World",
                "isBase64Encoded": false
            }
        """

        // When
        val outputStream = ByteArrayOutputStream()
        candidate.handleRequest(input.byteInputStream(), outputStream)

        // Then
        val actual = Json.decodeFromOutputStream<ApplicationLoadBalancerResponseEvent>(outputStream)
        val expected = ApplicationLoadBalancerResponseEvent(body = "Hello, World!")
        assertEquals(expected, actual)
    }
}
