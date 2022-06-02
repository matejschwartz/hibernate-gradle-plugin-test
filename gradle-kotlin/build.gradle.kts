import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.hibernate.orm") version "5.6.9.Final"
	war
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.kotlin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

// try v1
tasks.withType<org.hibernate.orm.tooling.gradle.EnhanceTask>().configureEach {
	options.enableLazyInitialization = true
	options.enableDirtyTracking = true
	options.enableAssociationManagement = true
	options.enableExtendedEnhancement = false
}

// try v2
hibernate {
	enhance (
		closureOf<org.hibernate.orm.tooling.gradle.EnhanceExtension> {
			enableLazyInitialization = true
			enableDirtyTracking = true
			enableAssociationManagement = true
			enableExtendedEnhancement = false
		}
	)
}

// For Hibernate v6
/*hibernate {
	enhancement {
		lazyInitialization(true)
		dirtyTracking(true)
		associationManagement(true)
		extendedEnhancement(false)
	}
}*/
