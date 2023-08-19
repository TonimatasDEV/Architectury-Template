@file:Suppress("DEPRECATION", "UnstableApiUsage")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

val minecraftVersion: String by extra
val forgeVersion: String by extra
val forgeLoaderRange: String by extra
val forgeMinecraftVersionRange: String by extra
val forgeArchitecturyVersionRange: String by extra
val architecturyVersion: String by extra
val modVersion: String by extra
val modName: String by extra
val modLicense: String by extra
val modIssueTracker: String by extra
val modAuthor: String by extra
val modDescription: String by extra

architectury {
    platformSetupLoomIde()
    forge()
}

loom {
    forge {
        mixinConfig("example-common.mixins.json")
        mixinConfig("example-forge.mixins.json")
    }
}

val common by configurations.creating
val shadowCommon by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentForge"].extendsFrom(common)

dependencies {
    forge("net.minecraftforge:forge:$minecraftVersion-$forgeVersion")
    modApi("dev.architectury:architectury-forge:$architecturyVersion")

    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionFabric")) { isTransitive = false }
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf(
            "modVersion" to modVersion, "modName" to modName, "modLicense" to modLicense, "modIssueTracker" to modIssueTracker,
            "forgeLoaderRange" to forgeLoaderRange, "forgeMinecraftVersionRange" to forgeMinecraftVersionRange,
            "modAuthor" to modAuthor, "modDescription" to modDescription, "forgeArchitecturyVersionRange" to forgeArchitecturyVersionRange)
    inputs.properties(replaceProperties)

    filesMatching("META-INF/mods.toml") {
        expand(replaceProperties)
    }
}

tasks.withType<ShadowJar> {
    exclude("fabric.mod.json")

    configurations = listOf(shadowCommon)
    archiveClassifier.set("dev-shadow")
}

tasks.withType<RemapJarTask> {
    val shadowTask = tasks.shadowJar.get()
    input.set(shadowTask.archiveFile)
    dependsOn(shadowTask)
    archiveClassifier.set("")
}

tasks.jar {
    archiveClassifier.set("dev")
}

tasks.sourcesJar {
    val commonSources = project(":common").tasks.sourcesJar.get()
    dependsOn(commonSources)
    from(commonSources.archiveFile.map { zipTree(it) })
}

components.getByName<AdhocComponentWithVariants>("java").apply {
    withVariantsFromConfiguration(project.configurations["shadowRuntimeElements"]) {
        skip()
    }
}
