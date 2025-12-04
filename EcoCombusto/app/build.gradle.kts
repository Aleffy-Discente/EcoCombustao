    plugins {
        alias(libs.plugins.android.application)
        alias(libs.plugins.kotlin.android)
        alias(libs.plugins.kotlin.compose)
        id("com.google.devtools.ksp") version "2.2.21-2.0.4"

    }

    android {
        namespace = "com.example.ecocombusto"
        compileSdk = 36
        defaultConfig {
            applicationId = "com.example.ecocombusto"
            minSdk = 24
            targetSdk = 35
            versionCode = 1
            versionName = "1.0"
            packaging {
                resources {
                    excludes += "META-INF/versions/9/OSGI-INF/MANIFEST.MF"
                }
            }
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        kotlinOptions {
            jvmTarget = "11"
        }
        buildFeatures {
            compose = true
        }
    }
    dependencies {
        implementation(libs.androidx.compose.ui)
        implementation(libs.androidx.compose.material3)
        implementation(libs.androidx.activity.compose.v180)
        implementation(libs.androidx.navigation.compose)
        implementation(libs.androidx.lifecycle.runtime.ktx.v262)
        implementation(libs.androidx.lifecycle.viewmodel.compose)
        implementation(libs.retrofit.v290)
        implementation(libs.converter.gson)
        implementation(libs.logging.interceptor)
        implementation(libs.kotlinx.coroutines.core.v173)
        implementation(libs.kotlinx.coroutines.android.v173)
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)
        implementation(libs.androidx.lifecycle.viewmodel.ktx)
        implementation(libs.androidx.room.runtime)
        implementation(libs.androidx.room.ktx)
        ksp(libs.androidx.room.compiler)
        implementation(libs.retrofit)
        implementation (libs.gson)
    }
