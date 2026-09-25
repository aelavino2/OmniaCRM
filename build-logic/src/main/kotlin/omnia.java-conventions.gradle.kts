// Общие настройки для всех JVM-модулей: Java toolchain 25 (REQ-15.1).
// Kotlin-модули тоже подключают этот плагин: плагин Kotlin применяет плагин java,
// и jvmToolchain берётся из этого же toolchain.
plugins {
    java
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
