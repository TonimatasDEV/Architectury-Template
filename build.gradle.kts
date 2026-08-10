plugins {
    java
    id("architectury-plugin") version "3.5-SNAPSHOT"
    id("dev.architectury.loom") version "1.17-SNAPSHOT" apply false
    id("com.gradleup.shadow") version "9.5.1" apply false
}

val minecraftVersion: String by extra
val modVersion: String by extra
val mavenGroup: String by extra
val customArchivesBaseName: String by extra

architectury {
    minecraft = minecraftVersion
}

allprojects {
    apply(plugin = "java")

    version = modVersion
    group = mavenGroup
}

subprojects {
    apply(plugin = "dev.architectury.loom-no-remap")
    apply(plugin = "architectury-plugin")

    base {
        archivesName.set(customArchivesBaseName + project.name)
    }

    //configure<LoomGradleExtensionAPI> {
    //    silentMojangMappingsLicense()
    //}

    dependencies {
        "minecraft"("com.mojang:minecraft:$minecraftVersion")
        //"mappings"(project.the<LoomGradleExtensionAPI>().officialMojangMappings())
    }

    java {
        withSourcesJar()

        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(25)
    }
}
