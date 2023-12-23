plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
    id("net.saliman.cobertura") version "4.0.0"
}
rootProject.name = "aws-lambda-kotlin-libs"

include("aws-lambda-kotlin-events")
