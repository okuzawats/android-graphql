plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "com.okuzawats.poke.design"
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
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.material3)
  implementation(libs.androidx.ui.graphics)
}
