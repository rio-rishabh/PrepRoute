plugins {
    application
    java
    id("org.openapi.generator") version "7.10.0"   // ← add here
}

group = "prep.route"
version = "0.1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2")

    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass.set("prep.route.PrepRouteMain")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

// ↓ new: generate models from openapi/Question.yaml
openApiGenerate {
    generatorName.set("java")
    inputSpec.set("$rootDir/openapi/Question.yaml")
    outputDir.set(layout.buildDirectory.dir("generated/openApi").get().asFile.absolutePath)
    apiPackage.set("prep.route.jev.api")
    modelPackage.set("prep.route.jev.model")
    invokerPackage.set("prep.route.jev.invoker")
    globalProperties.set(
        mapOf(
            "models" to "",
            "apis" to "false",
            "supportingFiles" to ""
        )
    )
    configOptions.set(
        mapOf(
            "library" to "native",
            "serializationLibrary" to "jackson",
            "useJakartaEe" to "false",
            "dateLibrary" to "java8",
            "openApiNullable" to "false"
        )
    )
}

sourceSets {
    main {
        java {
            srcDir(layout.buildDirectory.dir("generated/openApi/src/main/java"))
        }
    }
}

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}