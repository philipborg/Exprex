import com.jfrog.bintray.gradle.BintrayExtension

plugins {
    `build-scan`
    `maven-publish`
    kotlin("jvm") version "1.3.0"
    id("com.jfrog.bintray") version "1.8.4"
}

val junitVersion = "5.3.1"
val major = 1
val minor = 0
val patch = 0
val versionId = "$major.$minor.$patch"

group = "com.philipborg"
version = versionId

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib", "1.3.0"))
    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
    publishAlways()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

val publicationName = "mavenJava"

publishing {
    publications {
        register(publicationName, MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}

bintray {
    user = if (project.hasProperty("bintrayUser")) project.property("bintrayUser") as String else System.getenv("BINTRAY_USER")
    key = if (project.hasProperty("bintrayKey")) project.property("bintrayKey") as String else System.getenv("BINTRAY_KEY")
    setPublications(publicationName)
    pkg(closureOf<BintrayExtension.PackageConfig> {
        repo = "Exprex"
        name = "Exprex"
        userOrg = "philipborg"
        setLicenses("Apache-2.0")
        vcsUrl = "https://github.com/philipborg/Exprex.git"
        issueTrackerUrl = "https://github.com/philipborg/Exprex/issues"
        websiteUrl = "https://github.com/philipborg/Exprex"
        publicDownloadNumbers = true
        desc = "Math Expression library for Kotlin"
        githubRepo = "philipborg/Exprex"
        attributes = mapOf(Pair("maturity", "Development"))
        version(closureOf<BintrayExtension.VersionConfig> {
            name = versionId
        })
    })
}