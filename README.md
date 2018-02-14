# JacocoAndroidSample
To generate the coverage report in Android, we use Jacoco (Java Code Coverage), one of the most used tools in Java for this purpose.

Introduction
------------
Test coverage reports are an important tool to measure how much our tests actually exercise our code.


### build.gradle
Enabled test coverage in ```app/build.gradle``` 
```
android {
    ...
    buildTypes {
        debug {
            testCoverageEnabled true
        }
        ...
    }
}
```


### Create task for jacoco report

Create jacocoTestReport in ```app/build.gradle``` 
```
apply plugin: 'jacoco'

task jacocoTestReport(type: JacocoReport, dependsOn: 'testDebugUnitTest') {

    reports {
        xml.enabled = true
        html.enabled = true
    }

    def fileFilter = ['**/R.class', '**/R$*.class', '**/BuildConfig.*', '**/Manifest*.*', '**/*Test*.*', 'android/**/*.*']
    def debugTree = fileTree(dir: "${buildDir}/intermediates/classes/debug", excludes: fileFilter)
    def mainSrc = "${project.projectDir}/src/main/java"

    sourceDirectories = files([mainSrc])
    classDirectories = files([debugTree])
    executionData = files("${buildDir}/jacoco/testDebugUnitTest.exec")
}
```

Pre-requisites(Optional)
--------------

- Android SDK 26
- Android Build Tools v26.0.1
- Android Support Repository

Screenshots
-------------

<img src="AppShortcuts/images/reportPath.png" height="400" alt="Report Path"/> 
<img src="AppShortcuts/images/classes.png" height="400" alt="Java Classes"/> 
<img src="AppShortcuts/images/coverage.png" height="400" alt="Coverage"/> 


## Resources

Check out the following links for more details:

 * [Jacoco](http://www.eclemma.org/jacoco/)


Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.


