plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.hilt.plugin)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.okuzawats.poke"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.okuzawats.poke"
    minSdk = 33
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"

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
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_18.toString()
  }

  buildFeatures {
    compose = true
  }
}

dependencies {
  implementation(project(":api"))
  implementation(project(":core"))
  implementation(project(":design"))
  implementation(project(":feature:main"))
  implementation(project(":feature:version"))
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.hilt.navigation)
  implementation(libs.androidx.material3)
  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)
}
