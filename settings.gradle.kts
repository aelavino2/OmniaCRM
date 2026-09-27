pluginManagement {
    // Convention-плагины проекта (omnia.*): общие настройки сборки модулей
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    // Репозитории объявляются только здесь, модули своих не заводят
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        mavenCentral()
    }
}

rootProject.name = "omnia-crm"

include("core")
