plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.KOTLIN_KAPT)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId(AndroidConfig.APPLICATION_ID)

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
}

dependencies {
    implementation(project(Module.NETWORK))
    implementation(project(Module.NAVIGATION))

    implementation(JetBrains.kotlinStdLib)

    implementation(Android.material)

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)

    implementation(AndroidX.navigation)
    implementation(AndroidX.navigationKtx)

    implementation(Rx.java3)
    implementation(Rx.kotlin)

    implementation(Dagger.core)
    kapt(Dagger.compiler)

    testImplementation(Testing.jUnit)

    androidTestImplementation(AndroidX.jUnitExt)
    androidTestImplementation(AndroidX.espresso)
}