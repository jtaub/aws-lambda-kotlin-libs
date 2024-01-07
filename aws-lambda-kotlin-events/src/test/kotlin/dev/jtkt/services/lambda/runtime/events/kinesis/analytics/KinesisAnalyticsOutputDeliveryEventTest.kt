package dev.jtkt.services.lambda.runtime.events.kinesis.analytics

import dev.jtkt.services.lambda.runtime.lambdaJsonSerializationDefaults
import dev.jtkt.services.lambda.runtime.newLambdaHandler
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import kotlin.test.Test

class KinesisAnalyticsOutputDeliveryEventTest {

    private val candidate = newLambdaHandler { event: KinesisAnalyticsOutputDeliveryEvent, _ ->
        KinesisAnalyticsOutputDeliveryResponse(
            records = event.records.map {
                KinesisAnalyticsOutputDeliveryResponse.Record(
                    recordId = it.recordId,
                )
            }
        )
    }


    @Test
    fun simpleTest() {
        // Given
        // I was not able to find sample JSON on the AWS website for this one.
        val input = Json.encodeToString(
            KinesisAnalyticsOutputDeliveryEvent(
                records = listOf(KinesisAnalyticsOutputDeliveryEvent.Record(recordId = "42"))
            )
        )

        // When
        val outputStream = ByteArrayOutputStream()
        candidate(input.byteInputStream(), outputStream, null)

        // Then
        val actual =
            Json.decodeFromString<KinesisAnalyticsOutputDeliveryResponse>(outputStream.toString(Charsets.UTF_8))
        val expected = KinesisAnalyticsOutputDeliveryResponse(
            records = listOf(KinesisAnalyticsOutputDeliveryResponse.Record(recordId = "42"))
        )
        assertEquals(expected, actual)
    }
}