# aws-lambda-kotlin-libs

Very unofficial repo for interfaces and helper classes for Kotlin on AWS Lambda (without baggage from Java)

This project aims to provide Kotlin-first support for AWS Lambda, with feature parity with AWS's own
[aws-lambda-java-libs](https://github.com/aws/aws-lambda-java-libs)

## Design Goals

Using Kotlin on AWS Lambda is pretty easy via the JAVA runtime, and for the most part, the Java libraries play very well
with Kotlin.
There are a couple of pain points though, which this project aims to address.

* No dependency on any runtime reflection, especially Jackson
* No dependency on Lombok
* No dependency on joda-time
* Explicit nullability annotations (in the original libraries, it's hard to know what will be null or not at runtime)
* Immutability by default.

These are actually pain-points from Java as well, but the problems are amplified in Kotlin.

## Non-goals

* kotlin-multiplatform support. Would love to add this in the future, but not for now.
* Re-writing the original Java libraries. If a certain class or interface works perfectly well from Kotlin (like
  [RequestStreamHandler](https://github.com/aws/aws-lambda-java-libs/blob/main/aws-lambda-java-core/src/main/java/com/amazonaws/services/lambda/runtime/RequestStreamHandler.java))
  then it won't be duplicated here.
* Support for old version of Kotlin and the JVM. Will be targeting Kotlin 1.9+ and Java 17+
