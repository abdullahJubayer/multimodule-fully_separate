import org.gradle.api.JavaVersion


object Versions {
    object Default{
        const val GRADLE = "8.1.1"
        const val KOTLIN = "1.9.10"
        const val KOTLIN_JVM = "1.9.10"
        val JAVA = JavaVersion.VERSION_17
        val JVM_TERGET_VERSION = "17"
    }

    object Core {
        const val KTX_CORE = "1.5.0"
        const val APPCOMPAT = "1.3.0"
        const val ACTIVITY_KTX = "1.2.0-alpha03"
        const val MATERIAL_3 = "1.4.0"

        const val CONSTRAINT_LAYOUT = "2.1.4"
        const val NAVIGATION = "2.7.6"

        const val DAGGER_HILT = "2.48"

        const val OKHTTP = "4.9.0"
        const val RETROFIT = "2.9.0"
        const val RETROFIT_KOTLIN_ADAPTER = "0.9.2"
        const val GLIDE_VERSION = "4.14.2"

        const val ANDROID_LIFECYCLE_VERSION = "2.7.0"
        const val PAGING_3 = "3.1.1"

        const val JUNIT = "4.13.2"
        const val JUNIT_INTEGRATION = "1.1.2"
        const val ESPRESSO = "3.3.0"
    }
}

object ANDROID_SDK_SUPPORT {
    const val VERSION_CODE = 1
    const val APPLICATION_ID = "com.example.myapplication"
    const val VERSION_NAME = "1.0.0"
    const val MIN_SDK = 19
    const val TARGET_SDK = 34
    const val COMPILE_SDK = 34
}