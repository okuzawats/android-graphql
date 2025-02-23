plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.hilt.plugin)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.okuzawats.poke.core"
  compileSdk = 35

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_18.toString()
  }
}

dependencies {
  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)
  implementation(libs.logcat)
}
