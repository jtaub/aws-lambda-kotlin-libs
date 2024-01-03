import javax.xml.parsers.DocumentBuilderFactory

plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("org.jetbrains.kotlinx.kover") version "0.7.5"
}

group = "dev.jtkt"
version = "1.0.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(project(":aws-lambda-kotlin-events"))
    testImplementation(kotlin("test"))
    kover(project(":aws-lambda-kotlin-events"))
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("kotlinx-serialization")
        plugin("org.jetbrains.kotlinx.kover")
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
}

koverReport {
    filters {
        includes {
            classes("dev.jtkt.*")
        }
    }

    verify {
        rule {
            bound {
                minValue = 4
            }
        }
    }
}

// IMPORTANT! Must be defined in the plugins block:
// plugins { id("org.jetbrains.kotlinx.kover") version ... }

tasks.register("printLineCoverage") {
    group = "verification" // Put into the same group as the `kover` tasks
    dependsOn("koverXmlReport")
    doLast {
        val report = file("build/reports/kover/report.xml")

        val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(report)
        val rootNode = doc.firstChild
        var childNode = rootNode.firstChild

        var coveragePercent = 0.0

        while (childNode != null) {
            if (childNode.nodeName == "counter") {
                val typeAttr = childNode.attributes.getNamedItem("type")
                if (typeAttr.textContent == "LINE") {
                    val missedAttr = childNode.attributes.getNamedItem("missed")
                    val coveredAttr = childNode.attributes.getNamedItem("covered")

                    val missed = missedAttr.textContent.toLong()
                    val covered = coveredAttr.textContent.toLong()

                    coveragePercent = (covered * 100.0) / (missed + covered)

                    break
                }
            }
            childNode = childNode.nextSibling
        }

        println("%.1f".format(coveragePercent))
    }
}
