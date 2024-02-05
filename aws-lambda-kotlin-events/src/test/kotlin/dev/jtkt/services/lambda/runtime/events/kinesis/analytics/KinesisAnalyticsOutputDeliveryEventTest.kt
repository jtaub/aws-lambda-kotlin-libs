package dev.jtkt.services.lambda.runtime.events.kinesis.analytics

import dev.jtkt.services.lambda.runtime.events.TestUtils.decodeFromOutputStream
import dev.jtkt.services.lambda.runtime.newLambdaHandler
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.ByteArrayOutputStream
import kotlin.test.Test

@ExperimentalSerializationApi
class KinesisAnalyticsOutputDeliveryEventTest {

    private val candidate = newLambdaHandler { event: KinesisAnalyticsOutputDeliveryEvent ->
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
        candidate.handleRequest(input.byteInputStream(), outputStream)

        // Then
        val actual = Json.decodeFromOutputStream<KinesisAnalyticsOutputDeliveryResponse>(outputStream)
        val expected = KinesisAnalyticsOutputDeliveryResponse(
            records = listOf(KinesisAnalyticsOutputDeliveryResponse.Record(recordId = "42"))
        )
        assertEquals(expected, actual)
    }
}