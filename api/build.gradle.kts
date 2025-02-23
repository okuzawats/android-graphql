plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.apollo.plugin)
  alias(libs.plugins.hilt.plugin)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.okuzawats.poke.api"
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
  implementation(libs.apollo.runtime)
  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)
  implementation(platform(libs.okhttp.bom))
  implementation(libs.okhttp.core)
  implementation(libs.okhttp.logging)
  testImplementation(libs.okhttp.mock)
}

apollo {
  // Set the package name to use for the generated models
  service("service") {
    packageName.set("com.okuzawats.poke.api")
  }
}
