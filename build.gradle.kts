plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.slf4j:slf4j-log4j12:1.7.32")
    testImplementation("org.slf4j:slf4j-api:1.7.32")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs
    compilerArgs.addAll(listOf("--add-exports", "java.rmi/sun.rmi.server=ALL-UNNAMED",  "--add-exports", "jdk.management.agent/jdk.internal.agent=ALL-UNNAMED"))
}