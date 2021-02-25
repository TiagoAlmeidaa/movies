include(":navigation")
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "movies"

include("feature_popular", "network", "app")