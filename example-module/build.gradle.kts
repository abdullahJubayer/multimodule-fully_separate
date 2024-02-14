import Dependencies.common

plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.DAGGER_HILT)
}

android {
    defaultConfig {
        namespace = "${ANDROID_SDK_SUPPORT.APPLICATION_ID}.example"
        compileSdk = ANDROID_SDK_SUPPORT.COMPILE_SDK
        minSdk = ANDROID_SDK_SUPPORT.MIN_SDK
    }

    compileOptions {
        sourceCompatibility = Versions.Default.JAVA
        targetCompatibility = Versions.Default.JAVA
    }
    kotlinOptions {
        jvmTarget = Versions.Default.JVM_TERGET_VERSION
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":base-module"))
    common()
}