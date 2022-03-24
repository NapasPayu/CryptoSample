plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.napas.cryptosample"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    dynamicFeatures += setOf(":feature:currencylist")
}

dependencies {
    implementation(project(":data:local"))
    implementation(project(":data:repository"))
    api(project(":domain"))
    implementation(libs.appcompat)
    implementation(libs.fragment)
    api(libs.core.ktx)
    api(libs.material)
    api(libs.koin)
    api(libs.bundles.navigation)
    api(libs.bundles.lifecycle)
    implementation(libs.junit)
    implementation(libs.coroutines.test)
}