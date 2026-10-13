plugins {
    id("omnia.java-conventions")
    `java-library`
    alias(libs.plugins.openapi.generator)
}

val generatedOpenApiDir = layout.buildDirectory.dir("generated/openapi")

openApiGenerate {
    generatorName = "spring"
    inputSpec = layout.projectDirectory.file("src/main/openapi/omnia-api.yaml")
    outputDir = generatedOpenApiDir
    apiPackage = "com.omniacrm.contracts.api"
    modelPackage = "com.omniacrm.contracts.model"
    generateApiTests = false
    generateModelTests = false
    generateApiDocumentation = false
    generateModelDocumentation = false
    configOptions = mapOf(
        "interfaceOnly" to "true",
        "useSpringBoot4" to "true",
        "useJakartaEe" to "true",
        "useTags" to "true",
        "skipDefaultInterface" to "true",
        "requestMappingMode" to "api_interface",
        "hideGenerationTimestamp" to "true",
        "generateJsonIncludeAnnotations" to "false",
        "generateJsonSetterNullsAnnotations" to "false",
        "openApiNullable" to "false",
        "documentationProvider" to "none",
        "annotationLibrary" to "none",
        "sourceFolder" to "src/main/java",
    )
}

dependencies {
    implementation(platform(libs.spring.boot.bom))

    api(libs.spring.web)
    api(libs.spring.context)
    api(libs.jakarta.validation.api)
    api(libs.jackson.annotations)
    implementation(libs.jakarta.annotation.api)
    compileOnly(libs.jakarta.servlet.api)
}

sourceSets {
    main {
        java.srcDir(generatedOpenApiDir.map { it.dir("src/main/java") })
    }
}

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}
