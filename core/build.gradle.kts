plugins {
    id("omnia.java-conventions")
    alias(libs.plugins.spring.boot)
}

dependencies {
    // Версии всех зависимостей Spring Boot берутся из его BOM
    implementation(platform(libs.spring.boot.bom))

    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.actuator)

    testImplementation(libs.spring.boot.starter.webmvc.test)
    testRuntimeOnly(libs.junit.platform.launcher)
}
