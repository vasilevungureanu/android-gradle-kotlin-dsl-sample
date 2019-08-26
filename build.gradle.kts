buildscript {
    repositories {
        google()
        gradlePluginPortal()
        jcenter()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.fabric.io/public") }
    }

    dependencies {
        classpath(GradlePlugins.android)
        classpath(GradlePlugins.apkSize)
        classpath(GradlePlugins.codeQualityTools)
        classpath(GradlePlugins.debLibs)
        classpath(GradlePlugins.easyLauncher)
        classpath(GradlePlugins.fabric)
        classpath(GradlePlugins.googleServices)
        classpath(GradlePlugins.kotlin)
        classpath(GradlePlugins.playPublisher)
    }
}

allprojects {
    repositories {
        google()
        gradlePluginPortal()
        jcenter()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.fabric.io/public") }
    }
}