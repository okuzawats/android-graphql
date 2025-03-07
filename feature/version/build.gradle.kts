plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt.plugin)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.okuzawats.poke.feature.version"
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
  implementation(project(":api"))
  implementation(project(":core"))
  implementation(libs.apollo.runtime)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.hilt.navigation)
  implementation(libs.androidx.material3)
  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)
  testImplementation(libs.junit)
  testImplementation(libs.mockk)
}
