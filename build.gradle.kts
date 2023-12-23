plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    jacoco
}

group = "dev.jtkt"
version = "1.0.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("jacoco")
        plugin("kotlinx-serialization")
    }

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
        implementation("com.amazonaws:aws-lambda-java-core:1.2.3")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    }

    tasks.test {
        useJUnitPlatform()
    }

    kotlin {
        jvmToolchain(17)
    }

    jacoco {
        toolVersion = "0.8.11"
    }

    val jacocoTestReport by tasks.getting(JacocoReport::class) {
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
    }
}
