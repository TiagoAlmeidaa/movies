tasks.register<JacocoReport>("jacocoTestReport") {
    println("> ${project.name}:jacocoTestReport - register started")

    group = "verification"
    description = "Code coverage report for both Android and Unit tests."

    val testTask = tasks.getByName("testDebugUnitTest")
    dependsOn(testTask)

    reports {
        with(html) {
            isEnabled = true
            destination = file(Jacoco.getDestinationPath(project))
        }
    }

    val sourceDir = files(Jacoco.getSourceDirectories(project))
    val classDir = files(Jacoco.getClassDirectories(project))
    val execFiles = Jacoco.getExecutionData(project)

    sourceDirectories.setFrom(sourceDir)
    classDirectories.setFrom(classDir)
    executionData.setFrom(execFiles)

    println("> ${project.name}:jacocoTestReport - register finished")
}


