//tasks.register<JacocoReport>("jacocoProjectTestReport") {
//    println("")
//    println("")
//    println("> main:jacocoProjectTestReport - register started")
//
//    group = "verification"
//    description = "Code coverage of unit tests from all project modules"
//
//    reports {
//        with(html) {
//            isEnabled = true
//            destination = file(Jacoco.getDestinationPath(project))
//        }
//    }
//
//    subprojects.forEach { project ->
//        if (Jacoco.projectUsesJacoco(project)) {
//            println("> main:jacocoProjectTestReport - subproject :${project.name}")
//            val task = project.tasks.getByName("jacocoTestReport")
//            dependsOn(task)
//
//            val sourceDir = files(Jacoco.getSourceDirectories(project))
//            val classDir = files(Jacoco.getClassDirectories(project))
//            val execFiles = Jacoco.getExecutionData(project)
//
//            sourceDirectories.setFrom(sourceDir)
//            classDirectories.setFrom(classDir)
//            executionData.setFrom(execFiles)
//        }
//    }
//
//    println("> main:jacocoProjectTestReport - register finished")
//    println("")
//    println("")
//}

//val jacocoMerge by tasks.registering(JacocoMerge::class) {
//    subprojects {
//        executionData(tasks.withType<JacocoReport>().map { it.executionData })
//    }
//    destinationFile = file(Jacoco.getDestinationPath(project))
//}
//
//tasks.register<JacocoReport>("jacocoProjectTestReport") {
//    dependsOn(jacocoMerge)
//
//    val sourceDir = files(subprojects.map { it.the<SourceSetContainer>()["main"].allSource.srcDirs })
//    val classDir = files(subprojects.map { it.the<SourceSetContainer>()["main"].output })
//
//    sourceDirectories.from(sourceDir)
//    classDirectories.from(classDir)
//    executionData(jacocoMerge.get().destinationFile)
//
//    reports {
//        html.isEnabled = true
//    }
//}