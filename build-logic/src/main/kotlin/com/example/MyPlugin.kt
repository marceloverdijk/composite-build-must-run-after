package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

abstract class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        val dist = project.tasks.register("dist") {
            it.group = "Generate"
            it.description = "Generates dist file"
            it.doLast {
                val dataDir = project.layout.buildDirectory.dir("data").get().asFile
                val distFile = File(dataDir, "dist.txt")

                println("Writing dist file: ${distFile.absolutePath}")

                // Sleep to prove tests are running before dist task finished...
                Thread.sleep(5_000)

                dataDir.mkdirs()
                distFile.writeText(content())

                println("Writing dist file finished")
            }
        }

        project.tasks.named("assemble") {
            it.dependsOn(dist)
        }
    }
}
