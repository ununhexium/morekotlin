val assertJVersion = "3.9.1"
val junitPlatformVersion = "1.0.1"
val junitJupiterVersion = "5.1.0"

plugins {
  val kotlinVersion = "1.2.31"

  id("org.jetbrains.kotlin.jvm") version kotlinVersion
  java
  idea
}

idea {
  module {
    isDownloadSources = true
  }
}

repositories {
  mavenCentral()
}

version = "0.1.0-SNAPSHOT"

dependencies {
  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  compile("org.jetbrains.kotlin:kotlin-reflect")

  testImplementation("org.assertj:assertj-core:$assertJVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")

  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }
  dependencies {
    classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.+")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
