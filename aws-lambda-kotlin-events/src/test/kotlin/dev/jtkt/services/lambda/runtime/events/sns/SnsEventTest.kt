package dev.jtkt.services.lambda.runtime.events.sns

import dev.jtkt.services.lambda.runtime.events.titleCaseSerializer
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertEquals

class SnsEventTest {

    @Test
    fun deserialize() {
        // Given
        val json = """
            {
              "Records": [
                {
                  "EventVersion": "1.0",
                  "EventSubscriptionArn": "arn:aws:sns:us-east-1:123456789012:sns-lambda:21be56ed-a058-49f5-8c98-aedd2564c486",
                  "EventSource": "aws:sns",
                  "Sns": {
                    "SignatureVersion": "1",
                    "Timestamp": "2019-01-02T12:45:07.000Z",
                    "Signature": "...65r==",
                    "SigningCertUrl": "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-ac565b8b1a6c5d002d285f9598aa1d9b.pem",
                    "MessageId": "95df01b4-ee98-5cb9-9903-4c221d41eb5e",
                    "Message": "Hello from SNS!",
                    "MessageAttributes": {
                      "Test": {
                        "Type": "String",
                        "Value": "TestString"
                      },
                      "TestBinary": {
                        "Type": "Binary",
                        "Value": "TestBinary"
                      }
                    },
                    "Type": "Notification",
                    "UnsubscribeUrl": "https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&amp;SubscriptionArn=arn:aws:sns:us-east-1:123456789012:test-lambda:21be56ed-a058-49f5-8c98-aedd2564c486",
                    "TopicArn":"arn:aws:sns:us-east-1:123456789012:sns-lambda",
                    "Subject": "TestInvoke"
                  }
                }
              ]
            }
        """

        // When
        val actual = titleCaseSerializer.decodeFromString<SnsEvent>(json)

        // Then
        val expected = SnsEvent(
            records = listOf(
                SnsEvent.SnsRecord(
                    eventVersion = "1.0",
                    eventSource = "aws:sns",
                    eventSubscriptionArn = "arn:aws:sns:us-east-1:123456789012:sns-lambda:21be56ed-a058-49f5-8c98-aedd2564c486",
                    sns = SnsEvent.Sns(
                        signatureVersion = "1",
                        timestamp = Instant.parse("2019-01-02T12:45:07.000Z"),
                        signature = "...65r==",
                        signingCertUrl = "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-ac565b8b1a6c5d002d285f9598aa1d9b.pem",
                        messageId = "95df01b4-ee98-5cb9-9903-4c221d41eb5e",
                        message = "Hello from SNS!",
                        messageAttributes = mapOf(
                            "Test" to SnsEvent.MessageAttribute("String", "TestString"),
                            "TestBinary" to SnsEvent.MessageAttribute("Binary", "TestBinary")
                        ),
                        type = "Notification",
                        unsubscribeUrl = "https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&amp;SubscriptionArn=arn:aws:sns:us-east-1:123456789012:test-lambda:21be56ed-a058-49f5-8c98-aedd2564c486",
                        topicArn = "arn:aws:sns:us-east-1:123456789012:sns-lambda",
                        subject = "TestInvoke"
                    )
                )
            )
        )

        assertEquals(expected, actual)
    }
}