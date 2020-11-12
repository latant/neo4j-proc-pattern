plugins {
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/ktor")
    maven("https://dl.bintray.com/kotlin/kotlinx")
}

dependencies {
    fun ktor(module: String) = "io.ktor:ktor-$module:1.4.0"

    implementation(kotlin("stdlib"))
    implementation(ktor("server-netty"))
    implementation(ktor("html-builder"))
    implementation(ktor("auth-jwt"))
    implementation(ktor("serialization"))
    implementation("org.neo4j.driver:neo4j-java-driver:4.1.1")
    implementation(project(":common"))

    testImplementation(kotlin("test-junit"))
    testImplementation(ktor("server-test-host"))
    testImplementation(project(":neo4j-plugin"))
    testImplementation("org.neo4j.test:neo4j-harness:4.1.4")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}