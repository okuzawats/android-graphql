package com.okuzawats.poke

import android.app.Application
import logcat.AndroidLogcatLogger
import logcat.LogPriority

class PokeApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    // Log all priorities in debug builds, no-op in release builds.
    AndroidLogcatLogger.installOnDebuggableApp(
      application = this,
      minPriority = LogPriority.VERBOSE,
    )
  }
}
