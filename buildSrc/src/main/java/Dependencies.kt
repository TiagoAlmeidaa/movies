internal object Versions {
    const val gradle = "4.2.1"
    const val material = "1.3.0"
    const val kotlin = "1.4.30"
    const val safeArgs = "2.3.2"
    const val coreKtx = "1.3.2"
    const val appCompat = "1.2.0"
    const val navigation = "2.3.3"
    const val recyclerView = "1.2.0-alpha04"
    const val jUnitExt = "1.1.2"
    const val espresso = "3.3.0"
    const val dagger = "2.29.1"
    const val retrofit = "2.9.0"
    const val leakCanary = "2.7"
    const val rxJava3 = "3.0.0"
    const val glide = "4.12.0"
    const val dependenciesChecker = "0.36.0"
    const val viewBindingDelegate = "1.4.4"
    const val jUnit = "4.13.2"
    const val mockK = "1.10.6"
}

object Android {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object JetBrains {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
}

object AndroidX {
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Dagger {
    const val core = "com.google.dagger:dagger:${Versions.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object Square {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitRxJava3Adapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}

object Rx {
    const val java3 = "io.reactivex.rxjava3:rxjava:${Versions.rxJava3}"
    const val kotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxJava3}"
    const val android = "io.reactivex.rxjava3:rxandroid:${Versions.rxJava3}"
}

object BumpTech {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object Util {
    const val dependenciesChecker = "com.github.ben-manes:gradle-versions-plugin:${Versions.dependenciesChecker}"
    const val viewBindingDelegate = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBindingDelegate}"
}

object Testing {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val mockK = "io.mockk:mockk:${Versions.mockK}"
}