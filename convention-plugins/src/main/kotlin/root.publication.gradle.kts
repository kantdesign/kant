plugins {
    id("io.github.gradle-nexus.publish-plugin")
}

allprojects {
    group = "org.jetbrains.kotlinx.multiplatform-library-template"
    version = "0.0.1"
}

nexusPublishing {
    // Configure maven central repository
    // https://github.com/gradle-nexus/publish-plugin#publishing-to-maven-central-via-sonatype-ossrh
    repositories {
        sonatype {
            username = "VaZ4XzFJ"
            password = "LvWtRvvI/mUZcwa6KKdkqCl3uQFrxSGLkMRadN7Irg9m"
        }
    }
}
