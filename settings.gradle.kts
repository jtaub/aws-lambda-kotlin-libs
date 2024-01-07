plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "aws-lambda-kotlin-libs"

include("aws-lambda-kotlin-events")
include("aws-lambda-kotlin-core")
