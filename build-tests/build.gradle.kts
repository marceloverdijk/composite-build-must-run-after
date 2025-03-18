plugins {
    kotlin("jvm") version "2.1.10"
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("stdlib"))
    testImplementation("com.example:build-logic-commons:1.0")
    testImplementation(kotlin("test"))
}

tasks.withType<Test>().configureEach {
    outputs.upToDateWhen { false }
    useJUnitPlatform()
    testLogging {
        events("failed", "passed", "skipped")
    }
}