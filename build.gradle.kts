//import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Android.gradle)
        classpath(JetBrains.kotlinGradlePlugin)
        classpath(AndroidX.safeArgs)
        classpath(Util.dependenciesChecker)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

//tasks {
//    "dependencyUpdates"(DependencyUpdatesTask::class) {
//        resolutionStrategy {
//            componentSelection {
//                all {
//                    val rejected = listOf("alpha", "beta", "rc", "cr", "m", "preview")
//                        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-]*") }
//                        .any { it.matches(candidate.version) }
//                    if (rejected) {
//                        reject("Release candidate")
//                    }
//                }
//            }
//        }
//    }
//}