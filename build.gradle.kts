plugins {
    `build-scan`
    kotlin("jvm") version "1.2.71"
}

val junitVersion = "5.3.1";

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib", "1.2.31"))
    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

buildScan {
    setLicenseAgreementUrl("https://gradle.com/terms-of-service")
    setLicenseAgree("yes")

    publishAlways()
}

tasks.withType<Test> {
    useJUnitPlatform()
}