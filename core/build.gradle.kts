plugins {
    id("omnia.java-conventions")
    alias(libs.plugins.spring.boot)
}

dependencies {
    // Версии всех зависимостей Spring Boot берутся из его BOM
    implementation(platform(libs.spring.boot.bom))

    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.flyway)
    runtimeOnly(libs.postgresql)
    runtimeOnly(libs.flyway.database.postgresql)

    testImplementation(libs.spring.boot.starter.webmvc.test)
    testImplementation(libs.spring.boot.testcontainers)
    testImplementation(libs.testcontainers.postgresql)
    testRuntimeOnly(libs.junit.platform.launcher)
}

// Локально core берёт настройки БД из того же .env, что и Docker Compose.
// Переменные, уже заданные в окружении, важнее значений из файла.
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
