import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
    signing
}

publishing {
    // Configure all publications
    publications.withType<MavenPublication> {
        groupId = "com.kant.design"
        version = "0.0.1"
        // Stub javadoc.jar artifact
        artifact(tasks.register("${name}JavadocJar", Jar::class) {
            archiveClassifier.set("javadoc")
            archiveAppendix.set(this@withType.name)
        })

        // Provide artifacts information required by Maven Central
        pom {
            name.set("Kant Design")
            description.set("Ant Design for Kotlin's Compose Multiplatform")
            url.set("https://github.com/kantdesign/kant")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("KantDesign")
                    name.set("KantDesign Team")
                    organization.set("KantDesign")
                    organizationUrl.set("https://ant.design")
                }
            }
            scm {
                url.set("https://github.com/kantdesign/kant")
            }
        }
    }
}

signing {
    if (project.hasProperty("signing.gnupg.keyName")) {
        useGpgCmd()
        sign(publishing.publications)
    }
}
