package dev.jtkt.services.lambda.runtime.events.kinesis.streams

enum class EncryptionType(val value: String) {
    NONE("NONE"),
    KMS("KMS");
}
