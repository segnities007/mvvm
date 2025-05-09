plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
    id("androidx.room")
}

android {
    namespace = "com.example.core_module"
    compileSdk = 35
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":feature"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    // room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //koin
    implementation(libs.koin.androidx.compose)
}
