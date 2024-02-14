import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {
        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Default.KOTLIN}"
        const val KTX_CORE = "androidx.core:core-ktx:${Versions.Core.KTX_CORE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.Core.APPCOMPAT}"
        const val MATERIAL_DESIGN = "com.google.android.material:material:${Versions.Core.MATERIAL_3}"

        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.Core.CONSTRAINT_LAYOUT}"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.Core.ACTIVITY_KTX}"
        const val FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.Core.NAVIGATION}"
        const val NAVIGATION = "androidx.navigation:navigation-ui-ktx:${Versions.Core.NAVIGATION}"

        const val DAGGER_HILT = "com.google.dagger:hilt-android:${Versions.Core.DAGGER_HILT}"
        const val DAGGER_HILT_COMPILER = "com.google.dagger:hilt-compiler:${Versions.Core.DAGGER_HILT}"

        const val OKHTTP_BOM = "com.squareup.okhttp3:okhttp-bom:${Versions.Core.OKHTTP}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp"
        const val OKHTTP_INTRERCEPTOR = "com.squareup.okhttp3:logging-interceptor"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Core.RETROFIT}"
        const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.Core.RETROFIT}"
        const val RETROFIT_KOTLIN_ADAPTER = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.Core.RETROFIT_KOTLIN_ADAPTER}"
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.Core.GLIDE_VERSION}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.Core.GLIDE_VERSION}"

        const val ANDROID_LIFECYCLE = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Core.ANDROID_LIFECYCLE_VERSION}"
        const val ANDROID_LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Core.ANDROID_LIFECYCLE_VERSION}"
        const val PAGING_3 = "androidx.paging:paging-runtime-ktx:${Versions.Core.PAGING_3}"

        const val JUNIT = "junit:junit:${Versions.Core.JUNIT}"
        const val JUNIT_INTEGRATION = "androidx.test.ext:junit:${Versions.Core.JUNIT_INTEGRATION}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.Core.ESPRESSO}"


    fun DependencyHandlerScope.common() {
        "implementation"(KOTLIN_STDLIB)
        "implementation"(KTX_CORE)
        "implementation"(APPCOMPAT)
        "implementation"(MATERIAL_DESIGN)

        "implementation"(CONSTRAINT_LAYOUT)
        "implementation"(ACTIVITY_KTX)
        "implementation"(FRAGMENT_KTX)
        "implementation"(NAVIGATION)

        "implementation"(DAGGER_HILT)
        "kapt"(DAGGER_HILT_COMPILER)

        "implementation"(OKHTTP_BOM)
        "implementation"(OKHTTP)
        "implementation"(OKHTTP_INTRERCEPTOR)
        "implementation"(RETROFIT)
        "implementation"(RETROFIT_CONVERTER)
        "implementation"(RETROFIT_KOTLIN_ADAPTER)
        "implementation"(GLIDE)
        "annotationProcessor"(GLIDE_COMPILER)

        "implementation"(ANDROID_LIFECYCLE)
        "implementation"(ANDROID_LIVE_DATA)
        "implementation"(PAGING_3)
    }

    fun DependencyHandlerScope.commonIntegrationTest() {
        "androidTestImplementation"(JUNIT)
        "androidTestImplementation"(ESPRESSO_CORE)
    }
}