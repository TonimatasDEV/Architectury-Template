import net.fabricmc.loom.api.LoomGradleExtensionAPI

plugins {
    java
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("dev.architectury.loom") version "1.5-SNAPSHOT" apply false
}

val minecraftVersion: String by extra
val modVersion: String by extra
val mavenGroup: String by extra
val customArchivesBaseName: String by extra

architectury {
    minecraft = minecraftVersion
}

subprojects {
    apply(plugin = "dev.architectury.loom")

    base {
        archivesName.set(customArchivesBaseName + project.name)
    }

    configure<LoomGradleExtensionAPI> {
        silentMojangMappingsLicense()
    }

    dependencies {
        "minecraft"("com.mojang:minecraft:$minecraftVersion")
        "mappings"(project.the<LoomGradleExtensionAPI>().officialMojangMappings())
    }
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "architectury-plugin")

    version = modVersion
    group = mavenGroup

    repositories {

    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    java {
        withSourcesJar()
    }
}
