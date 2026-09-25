plugins {
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.kotlin.jpa) apply false
}

// Example for a module build.gradle.kts:
// dependencies {
//     implementation(platform(libs.spring.boot.bom))
//     implementation(libs.spring.boot.starter.web)
//     testImplementation(libs.spring.boot.starter.test)
// }
