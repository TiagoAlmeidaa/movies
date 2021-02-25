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
    api(project(Module.NETWORK))

    api(Android.material)

    api(AndroidX.coreKtx)
    api(AndroidX.appCompat)
    api(AndroidX.navigation)
    api(AndroidX.navigationKtx)

    implementation(Rx.java3)
    implementation(Rx.kotlin)

    kapt(Dagger.compiler)

    testImplementation(Testing.jUnit)

    androidTestImplementation(AndroidX.jUnitExt)
    androidTestImplementation(AndroidX.espresso)
}