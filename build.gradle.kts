plugins {
    kotlin("jvm") version "1.9.0"
}

group = "io.github.highright1234"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(8)
}