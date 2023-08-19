val fabricLoaderVersion: String by extra
val architecturyVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    modApi("dev.architectury:architectury:$architecturyVersion")
}

architectury {
    common("fabric", "forge")
}
