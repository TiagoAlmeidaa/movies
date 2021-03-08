pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "movies"

include("app", "feature_popular", ":feature_details", "common", "network",  "navigation", "model")