package dev.jtkt.services.lambda.runtime.events.model.kinesis

enum class EncryptionType(val value: String) {
    NONE("NONE"),
    KMS("KMS");
}
