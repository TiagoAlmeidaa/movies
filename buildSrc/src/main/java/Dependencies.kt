object Versions {
    const val gradle = "4.1.2"
    const val material = "1.3.0"
    const val kotlin = "1.4.30"
    const val coreKtx = "1.3.2"
    const val appCompat = "1.2.0"
    const val jUnitExt = "1.1.2"
    const val espresso = "3.3.0"
    const val jUnit = "4.13.2"
    const val dependenciesChecker = "0.36.0"
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
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Testing {
    const val jUnit = "junit:junit:${Versions.jUnit}"
}

object Util {
    const val dependenciesChecker = "com.github.ben-manes:gradle-versions-plugin:${Versions.dependenciesChecker}"
}