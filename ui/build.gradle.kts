plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "fl0wer.ui"
    compileSdk = 33

    defaultConfig {
        minSdk = 28
    }

    compileOptions.sourceCompatibility = JavaVersion.VERSION_17
    compileOptions.targetCompatibility = JavaVersion.VERSION_17
    kotlinOptions.jvmTarget = "17"

    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.5.1"
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
}
