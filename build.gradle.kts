plugins {
    distribution
    id("com.example")
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
}

tasks.register("checkDist") {
    dependsOn(gradle.includedBuild("build-tests").task(":test"))
    mustRunAfter("assemble")
}

tasks.check {
    dependsOn("checkDist")
}
