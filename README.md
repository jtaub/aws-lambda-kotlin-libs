# aws-lambda-kotlin-libs

Very unofficial repo for interfaces and helper classes for Kotlin on AWS Lambda (without baggage from Java)

This project aims to provide Kotlin-first support for AWS Lambda, with feature parity with AWS's own
[aws-lambda-java-libs](https://github.com/aws/aws-lambda-java-libs) from which this is derived from.

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

This project aims to deliver:

* Reduced cold start times.
* Smaller binary sizes.
* Kotlin-first APIs.

## Non-goals

* Support for old versions of Kotlin and the JVM. Will be targeting Kotlin 1.9+ and Java 17+
* Building a framework. This is just a collection libraries

## Roadmap

* (In-progress) Achieve feature parity with the official AWS Java libraries.
* Provide a suite of concrete examples
* Kotlin multiplatform support + support for the Lambda Node runtime.
* GraalVM native image support
