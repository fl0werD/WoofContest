plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "fl0wer.entity"
    compileSdk = 33

    defaultConfig {
        minSdk = 28
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions.sourceCompatibility = JavaVersion.VERSION_17
    compileOptions.targetCompatibility = JavaVersion.VERSION_17
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
}
