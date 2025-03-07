plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt.plugin)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.okuzawats.feature.main"
  compileSdk = 35

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
  implementation(project(":core"))
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.hilt.navigation)
  implementation(libs.androidx.material3)
  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)
}
