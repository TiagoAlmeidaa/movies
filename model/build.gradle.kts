plugins {
    id(Plugin.JAVA_LIBRARY)
    id(Plugin.KOTLIN)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(JetBrains.kotlinStdLib)
}