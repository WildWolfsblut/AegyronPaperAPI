plugins {
    id("java")
    id("maven-publish")
}

group = "de.itsjxsper"
version = "1.0.0"
description = "Public API for Aegyron Paper plugins"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    // Paper API
    compileOnly("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT")

    // Adventure API (for messaging)
    implementation("net.kyori:adventure-api:4.14.0")
    implementation("net.kyori:adventure-text-minimessage:4.14.0")

    // Annotations
    compileOnly("org.jetbrains:annotations:24.0.1")

    // Aegyron Common (for shared DTOs and exceptions)
    implementation("de.itsjxsper:aegyron-common:0.0.2")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}

tasks.javadoc {
    (options as StandardJavadocDocletOptions).apply {
        encoding = "UTF-8"
        addStringOption("Xdoclint:none", "-quiet")
        title = "Aegyron Paper API $version"
    }

    // Include only public API packages
    include("de/itsjxsper/aegyronapipaper/**")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Aegyron Paper API")
                description.set("Public API for developing Paper plugins that integrate with Aegyron Core")
                url.set("https://github.com/ItsJxsper/aegyron-network")

                developers {
                    developer {
                        id.set("itsjxsper")
                        name.set("ItsJxsper")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/ItsJxsper/aegyron-network.git")
                    developerConnection.set("scm:git:ssh://github.com/ItsJxsper/aegyron-network.git")
                    url.set("https://github.com/ItsJxsper/aegyron-network")
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ItsJxsper/aegyron-network")
            credentials {
                username = findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}
