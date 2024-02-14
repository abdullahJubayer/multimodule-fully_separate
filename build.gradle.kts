// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.ANDROID_APPLICATION) version Versions.Default.GRADLE apply false
    id(Plugins.KOTLIN_ANDROID) version Versions.Default.KOTLIN apply false
    id(Plugins.KOTLIN_JVM) version Versions.Default.KOTLIN_JVM apply false
    id(Plugins.DAGGER_HILT) version Versions.Core.DAGGER_HILT apply false
}