// Loads the root .env into bootRun; variables already set in the environment win.
val keyValueParts = 2

plugins.withId("org.springframework.boot") {
    tasks.named<JavaExec>("bootRun") {
        val envFile = rootProject.file(".env")
        if (envFile.exists()) {
            envFile.readLines()
                .map { it.trim() }
                .filter { it.isNotEmpty() && !it.startsWith("#") && "=" in it }
                .map { it.split("=", limit = keyValueParts) }
                .filter { (name, _) -> System.getenv(name.trim()) == null }
                .forEach { (name, value) -> environment(name.trim(), value.trim()) }
        }
    }
}
