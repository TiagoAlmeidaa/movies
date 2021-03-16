val fileFilter = mutableSetOf(
    "**/R.*",
    "**/R\$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Test*.*",
    "android/**/*.*",
    "**/*\$Lambda$*.*",
    "**/*\$inlined$*.*",
    "**/databinding/**/*.*",
    "**/android/databinding/*Binding.*",
    "**/BR.*",
    "**/R$*.*",
    "**/*_MembersInjector.*",
    "**/*Module_*Factory.*",
    "**/*Fragment*.*",
    "**/*Activity*.*",
    "**/*Adapter*.*",
    "**/*ViewPager*.*",
    "**/*ViewHolder*.*",
    "**/*Module*.*",
    "**/util/*",
    "**/ui/*"
)

val classDirectoriesTree = fileTree(project.buildDir) {
    include(
        "**/classes/**/main/**",
        "**/intermediates/classes/debug/**",
        "**/intermediates/javac/debug/*/classes/**",
        "**/tmp/kotlin-classes/debug/**"
    )
    exclude(fileFilter)
}

val sourceDirectoriesTree = fileTree("${project.buildDir}") {
    include(
        "src/main/java/**",
        "src/main/kotlin/**",
        "src/debug/java/**",
        "src/debug/kotlin/**"
    )
}

val executionDataTree = fileTree(project.buildDir) {
    include(
        "outputs/code_coverage/**/*.ec",
        "jacoco/jacocoTestReportDebug.exec",
        "jacoco/testDebugUnitTest.exec",
        "jacoco/test.exec"
    )
}

fun JacocoReport.setDirectories() {
    sourceDirectories.setFrom(sourceDirectoriesTree)
    classDirectories.setFrom(classDirectoriesTree)
    executionData.setFrom(executionDataTree)
}

tasks.register<JacocoReport>("jacocoUnitTestReport") {
    println("")
    println("> Creating task :jacocoAndroidTestReport STARTED")

    group = "verification"
    description = "Code coverage report for both Android and Unit tests."
    dependsOn("testDebugUnitTest")
    reports {
        html.isEnabled = true
        html.destination = file("${buildDir}/jacoco/reports/html/coverage-report")
    }
    setDirectories()

    println("> Creating task :jacocoAndroidTestReport FINISHED")
}
