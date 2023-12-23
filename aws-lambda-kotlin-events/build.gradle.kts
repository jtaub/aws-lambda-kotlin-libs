plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    jacoco
    id("net.razvan.jacoco-to-cobertura") version "1.1.2"
}

group = "dev.jtkt"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Wrapper> {
    gradleVersion = "8.5"
}

kotlin {
    jvmToolchain(17)
}
