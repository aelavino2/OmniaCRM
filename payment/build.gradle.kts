plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.spring.boot)
}

kotlin {
    jvmToolchain(25)
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.flyway)
    implementation(libs.kotlin.reflect)
    runtimeOnly(libs.postgresql)
    runtimeOnly(libs.flyway.database.postgresql)
}

tasks.bootRun {
    val envFile = rootProject.file(".env")
    if (envFile.exists()) {
        envFile.readLines()
            .map { it.trim() }
            .filter { it.isNotEmpty() && !it.startsWith("#") && "=" in it }
            .map { it.split("=", limit = 2) }
            .filter { (name, _) -> System.getenv(name.trim()) == null }
            .forEach { (name, value) -> environment(name.trim(), value.trim()) }
    }
}
