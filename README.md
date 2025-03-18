# Gradle Composite Build with `mustRunAfter`

`build.gradle.kts` in the root project has:

```kotlin
tasks.register("checkDist") {
    dependsOn(gradle.includedBuild("build-tests").task(":test"))
    mustRunAfter("assemble")
}

tasks.check {
    dependsOn("checkDist")
}
```

but when running `./gradlew clean assemble check` tests from the included build are executed before the `assemble` task is finished.

Expected behavior is that the `checkDist` task is executed after the `assemble` task is finished.
