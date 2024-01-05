package dev.jtkt.services.lambda.runtime.events.s3

import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class S3EventNotificationTest {
    @Test
    fun deserialize() {
        // Given
        val json = """
         {
           "Records": [
             {
               "eventVersion": "2.0",
               "eventSource": "aws:s3",
               "awsRegion": "us-east-1",
               "eventTime": "1970-01-01T00:00:00.000Z",
               "eventName": "ObjectCreated:Put",
               "userIdentity": {
                 "principalId": "EXAMPLE"
               },
               "requestParameters": {
                 "sourceIPAddress": "127.0.0.1"
               },
               "responseElements": {
                 "x-amz-request-id": "EXAMPLE123456789",
                 "x-amz-id-2": "EXAMPLE123/5678abcdefghijklambdaisawesome/mnopqrstuvwxyzABCDEFGH"
               },
               "s3": {
                 "s3SchemaVersion": "1.0",
                 "configurationId": "testConfigRule",
                 "bucket": {
                   "name": "my-bucket",
                   "ownerIdentity": {
                     "principalId": "EXAMPLE"
                   },
                   "arn": "arn:aws:s3:::my-bucket"
                 },
                 "object": {
                   "key": "test%2Fkey",
                   "size": 1024,
                   "eTag": "0123456789abcdef0123456789abcdef",
                   "sequencer": "0A1B2C3D4E5F678901"
                 }
               }
             }
           ]
         }
        """

        // When
        val actual = Json.decodeFromString<S3Event>(json)

        // Then
        val expected = S3EventNotification(
            records = listOf(
                S3EventNotificationRecord(
                    awsRegion = "us-east-1",
                    eventName = "ObjectCreated:Put",
                    eventSource = "aws:s3",
                    eventTime = Instant.parse("1970-01-01T00:00:00.000Z"),
                    eventVersion = "2.0",
                    requestParameters = RequestParametersEntity(
                        sourceIpAddress = "127.0.0.1"
                    ),
                    responseElements = ResponseElementsEntity(
                        xAmzId2 = "EXAMPLE123/5678abcdefghijklambdaisawesome/mnopqrstuvwxyzABCDEFGH",
                        xAmzRequestId = "EXAMPLE123456789"
                    ),
                    s3 = S3Entity(
                        configurationId = "testConfigRule",
                        bucket = S3BucketEntity(
                            arn = "arn:aws:s3:::my-bucket",
                            name = "my-bucket",
                            ownerIdentity = UserIdentityEntity(
                                principalId = "EXAMPLE"
                            )
                        ),
                        s3Object = S3ObjectEntity(
                            key = "test%2Fkey",
                            size = 1024,
                            eTag = "0123456789abcdef0123456789abcdef",
                            sequencer = "0A1B2C3D4E5F678901"
                        ),
                        s3SchemaVersion = "1.0",
                    ),
                    userIdentity = UserIdentityEntity(
                        principalId = "EXAMPLE"
                    )
                )
            )
        )
        assertEquals(expected, actual)
        assertEquals(
            expected.records.first().s3.s3Object.urlDecodedKey,
            actual.records.first().s3.s3Object.urlDecodedKey,
        )
    }
}