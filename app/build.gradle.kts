plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Config.compileSdkVersion)

    defaultConfig {
        applicationId = Config.applicationId

        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)

        versionCode = Git.getCommitsCount(project)
        versionName = Git.getLastTag(project)

        resConfigs("en")
    }

    signingConfigs {
        create("release") {
            val property = KeystoreProperties.load(file("signing/keystore.properties"))

            keyAlias = property.keyAlias
            keyPassword = property.keyPassword
            storeFile = file(property.storeFile)
            storePassword = property.storePassword
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles("proguard-rules.pro")

            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles("proguard-rules.pro")

            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(AndroidSupport.annotations)
    implementation(AndroidSupport.appCompat)
    implementation(AndroidSupport.cardView)
    implementation(AndroidSupport.design)
    implementation(AndroidSupport.recyclerView)
    implementation(AndroidSupport.v4)

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.fragmentKtx)

    compileOnly(AutoValue.gson)
    annotationProcessor(AutoValue.gson)
    kapt(AutoValue.gson)
    compileOnly(AutoValue.it)
    annotationProcessor(AutoValue.it)
    kapt(AutoValue.it)
    kapt(AutoValue.parcel)
    implementation(AutoValue.parcelAdapter)

    releaseImplementation(Chucker.noOp)
    debugImplementation(Chucker.op)

    kapt(Dagger.compiler)
    implementation(Dagger.runtime)

    debugImplementation(Hyperion.attr)
    debugImplementation(Hyperion.buildConfig)
    debugImplementation(Hyperion.crash)
    debugImplementation(Hyperion.core)
    debugImplementation(Hyperion.disk)
    debugImplementation(Hyperion.geigerCounter)
    debugImplementation(Hyperion.measurement)
    debugImplementation(Hyperion.phoenix)
    debugImplementation(Hyperion.recorder)
    debugImplementation(Hyperion.simpleItem)
    debugImplementation(Hyperion.sharedPreference)
    debugImplementation(Hyperion.timber)

    implementation(Kotlin.stdLib)

    implementation(OkHttp.it)
    implementation(OkHttp.logging)

    implementation(PlayServices.location)
    implementation(PlayServices.places)

    implementation(Retrofit.adapterRxJava)
    implementation(Retrofit.converterGson)
    implementation(Retrofit.it)

    implementation(RxJava.it)
    implementation(RxJava.rxAndroid)
    implementation(RxJava.rxRelay)

    implementation(Unclassified.checkView)
    implementation(Unclassified.circleImageView)
    implementation(Unclassified.crashlytics) { isTransitive = true }
    implementation(Unclassified.dexter)
    implementation(Unclassified.firebaseMessaging)
    implementation(Unclassified.gson)
    debugImplementation(Unclassified.leakCanary)
    implementation(Unclassified.materialDateTimePicker) { exclude(group = "com.android.support") }
    implementation(Unclassified.materialDialogs)
    implementation(Unclassified.materialValues)
    implementation(Unclassified.picasso)
    implementation(Unclassified.qrCodeReaderView)
    implementation(Unclassified.qrGen)
    implementation(Unclassified.reactiveLocation)
    implementation(Unclassified.rxContacts)
    implementation(Unclassified.rxLint)
    implementation(Unclassified.swipeLayout)
    implementation(Unclassified.timber)
}