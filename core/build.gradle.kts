plugins {
    id("omnia.java-conventions")
    id("omnia.dotenv")
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(platform(libs.spring.boot.bom))

    implementation(project(":contracts"))
    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.flyway)
    implementation(libs.springdoc.openapi.starter.webmvc.ui)
    runtimeOnly(libs.postgresql)
    runtimeOnly(libs.flyway.database.postgresql)

    testImplementation(libs.spring.boot.starter.webmvc.test)
    testImplementation(libs.spring.boot.testcontainers)
    testImplementation(libs.testcontainers.postgresql)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.bootRun {
    // Local run opens Swagger UI; disable with -PopenSwagger=false
    systemProperty("omnia.dev.open-swagger-ui", providers.gradleProperty("openSwagger").getOrElse("true"))
}
