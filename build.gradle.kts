plugins {
    id("com.orange.foundation.jvm.application") version "0.1.0"
    id("io.micronaut.application") version "2.0.6"
    id("org.sonarqube") version "3.3"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.10"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.4.10"
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
}

version = "0.1"
group = "com.jocivaldias"

val micronautVersion: String by project
val artifactoryUrl: String by project
val foundationMicronautVersion: String by project
val kotlinVersion: String by project

dependencies {

    kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")

    implementation(platform("com.orange.foundation.jvm:micronaut:$foundationMicronautVersion"))
    implementation("micronaut:rest-server")

    annotationProcessor("io.micronaut.data:micronaut-data-processor")
    implementation("io.micronaut.sql:micronaut-hibernate-jpa")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    runtimeOnly("org.postgresql:postgresql")

    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("io.micronaut:micronaut-http")

    //tests
    kaptTest("io.micronaut:micronaut-inject-java")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
    maven {
        url = uri(artifactoryUrl)
    }
}

application {
    mainClass.set("com.jocivaldias.ApplicationKt")
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.orange.foundation.jvm.*", "com.jocivaldias.*")
    }
}

tasks {
    "shadowJar"(com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar::class) {
        isZip64 = true
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

sonarqube {
    properties {
        property ("sonar.projectKey", "financas")
    }
}