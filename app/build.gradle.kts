import Dependencies.common
import Dependencies.commonIntegrationTest

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.DAGGER_HILT)
}

android {
    namespace = ANDROID_SDK_SUPPORT.APPLICATION_ID
    compileSdk = ANDROID_SDK_SUPPORT.COMPILE_SDK

    defaultConfig {
        applicationId = ANDROID_SDK_SUPPORT.APPLICATION_ID
        minSdk = ANDROID_SDK_SUPPORT.MIN_SDK
        targetSdk = ANDROID_SDK_SUPPORT.TARGET_SDK
        versionCode = ANDROID_SDK_SUPPORT.VERSION_CODE
        versionName = ANDROID_SDK_SUPPORT.VERSION_NAME
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        debug {
            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = Versions.Default.JAVA
        targetCompatibility = Versions.Default.JAVA
    }
    kotlinOptions {
        jvmTarget = Versions.Default.JVM_TERGET_VERSION
    }
}

dependencies {
    common()
    implementation(project(":base-module"))
    implementation(project(":example-module"))
    commonIntegrationTest()
}