// Shared settings for every JVM module (Java and Kotlin): Java 25 toolchain and JUnit Platform.
plugins {
    java
}

group = "com.omniacrm"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
