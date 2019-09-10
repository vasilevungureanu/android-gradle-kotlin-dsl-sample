buildscript {
    repositories {
        google()
        gradlePluginPortal()
        jcenter()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.fabric.io/public") }
    }

    dependencies {
        classpath(GradlePlugin.android)
        classpath(GradlePlugin.apkSize)
        classpath(GradlePlugin.codeQualityTools)
        classpath(GradlePlugin.debLibs)
        classpath(GradlePlugin.easyLauncher)
        classpath(GradlePlugin.fabric)
        classpath(GradlePlugin.googleServices)
        classpath(GradlePlugin.kotlin)
        classpath(GradlePlugin.playPublisher)
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
