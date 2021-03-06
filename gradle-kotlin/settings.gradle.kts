pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.hibernate.orm") {
                useModule("org.hibernate:hibernate-gradle-plugin:${requested.version}")
            }
        }
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }
}
rootProject.name = "hbnt"
