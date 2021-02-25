object Plugin {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_KAPT = "kotlin-kapt"
}

object AndroidConfig {
    const val APPLICATION_ID = "com.tiago.movies"
    const val COMPILE_SDK_VERSION = 30
    const val BUILD_TOOLS_VERSION = "30.0.3"

    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 30
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

object Module {
    const val APP = ":app"
    const val NETWORK = ":network"
    const val NAVIGATION = ":navigation"
}

object BuildType {
    const val RELEASE = "release"
    const val DEBUG = "debug"
}

object ProGuard {
    const val TXT = "proguard-android.txt"
    const val PRO = "proguard-rules.pro"
}

