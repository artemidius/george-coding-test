import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlinx-serialization")
    id ("kotlin-parcelize")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sborets.codingtest"
    defaultConfig {
        applicationId = "com.sborets.codingtest"
        minSdk = 24
        targetSdk = 33
        compileSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (libs.bundles.android.ui)
    implementation (libs.bundles.compose)
    implementation (libs.bundles.ktor)

    implementation (libs.androidx.lifecycle.runtimeCompose)
    implementation (libs.androidx.lifecycle.viewModelCompose)
    implementation (libs.coil)
    implementation (libs.hilt.android)
    implementation (libs.hilt.navigation.compose)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.kotlinx.serialization.json)
    implementation (libs.ktx.core)

    kapt(libs.hilt.compiler)

    testImplementation (libs.kotlinx.coroutines.test)
    testImplementation (libs.junit.base)
    testImplementation (libs.bundles.mockito)
    testImplementation (libs.mockito.inline)
    testImplementation (libs.ktor.mock)
    androidTestImplementation (libs.junit.ext)
}

kapt {
    correctErrorTypes = true
}
