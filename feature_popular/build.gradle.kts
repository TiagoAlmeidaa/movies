plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.KOTLIN_KAPT)
    id(Plugin.SAFE_ARGS)
    id(Plugin.JACOCO)
}

jacoco {
    toolVersion = "0.8.7"
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(ProGuard.TXT, ProGuard.PRO)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    api(project(Module.COMMON))

    implementation(JetBrains.kotlinStdLib)

    implementation(Android.material)

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.recyclerView)

    implementation(Rx.java3)
    implementation(Rx.kotlin)
    implementation(Rx.android)

    implementation(AndroidX.navigation)
    implementation(AndroidX.navigationKtx)

    implementation(Dagger.core)
    kapt(Dagger.compiler)

    implementation(BumpTech.glide)

    testImplementation(Testing.jUnit)
    testImplementation(Testing.mockK)
}

apply(from = "${project.rootDir}/jacoco-module.gradle.kts")