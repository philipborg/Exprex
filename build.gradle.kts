plugins {
    `build-scan`
    kotlin("jvm") version "1.3.0"
}

val junitVersion = "5.3.1";

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