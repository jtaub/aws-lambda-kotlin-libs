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
    testImplementation(kotlin("test"))
    kover(project(":aws-lambda-kotlin-core"))
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

tasks.register("printLineCoverage") {
    group = "verification"
    dependsOn("koverXmlReport")
    doLast {
        val report = file("build/reports/kover/report.xml")

        val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(report)
        val rootNode = doc.firstChild
        val nodes = generateSequence(rootNode.firstChild) { it.nextSibling }
        val coverageNode = nodes.find { node ->
            node.nodeName == "counter" && node.attributes.getNamedItem("type")?.textContent == "LINE"
        }

        val coveragePercent = coverageNode?.let {
            val missedAttr = it.attributes.getNamedItem("missed")
            val coveredAttr = it.attributes.getNamedItem("covered")

            val missed = missedAttr.textContent.toLong()
            val covered = coveredAttr.textContent.toLong()

            (covered * 100.0) / (missed + covered)
        } ?: 0.0
        println("%.1f".format(coveragePercent))
    }
}
