plugins {
    id("com.gradleup.shadow")
}

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    accessWidenerPath.set(project(":common").loom.accessWidenerPath)
    
    fabricApi.configureDataGeneration {
        modId.set("example")
        outputDirectory.set(rootDir.resolve("common/src/main/generated"))
    }
}

val minecraftVersion: String by extra
val fabricApiVersion: String by extra
val fabricLoaderVersion: String by extra
val fabricLoaderRange: String by extra
val fabricMinecraftVersionRange: String by extra
val modVersion: String by extra
val modName: String by extra
val modLicense: String by extra
val modIssueTracker: String by extra
val modAuthor: String by extra
val modDescription: String by extra

val common: Configuration by configurations.creating
val shadowCommon: Configuration by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentFabric"].extendsFrom(common)

dependencies {
    implementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")

    // Dependencies (OPTIONAL)
    api("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion+$minecraftVersion") // Fabric API

    common(project(path = ":common")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionFabric")) { isTransitive = false }
}

tasks.processResources {
    val replaceProperties = mapOf(
            "modVersion" to modVersion, "modName" to modName, "modLicense" to modLicense, "modIssueTracker" to modIssueTracker,
            "fabricLoaderRange" to fabricLoaderRange, "fabricMinecraftVersionRange" to fabricMinecraftVersionRange,
            "modAuthor" to modAuthor, "modDescription" to modDescription)

    inputs.properties(replaceProperties)

    filesMatching("fabric.mod.json") {
        expand(replaceProperties)
    }
}

tasks.jar {
    archiveClassifier = "raw"
}

tasks.shadowJar {
    dependsOn("jar")
    configurations = listOf(shadowCommon)
    from(zipTree(tasks.jar.get().archiveFile))
    archiveClassifier.set(null)
}
