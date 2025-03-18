plugins {
    `java-gradle-plugin`
    kotlin("jvm") version "2.1.10"
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.example:build-logic-commons:1.0")
}

gradlePlugin {
    plugins {
        create("myplugin") {
            id = "com.example"
            implementationClass = "com.example.MyPlugin"
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjvm-default=all")
    }
}
