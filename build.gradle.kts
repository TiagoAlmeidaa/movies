//import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Android.gradle)
        classpath(JetBrains.kotlinGradlePlugin)
        classpath(AndroidX.safeArgs)
        //classpath(Util.dependenciesChecker)
        //classpath("org.jacoco:org.jacoco.core:0.8.7")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

//apply(from = "${project.rootDir}/jacoco-project.gradle.kts")

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