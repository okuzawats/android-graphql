package com.okuzawats.poke.startup

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import logcat.AndroidLogcatLogger
import logcat.LogPriority

@Suppress("unused")
/**
 * an [androidx.startup.Initializer] that startups Logcat.
 *
 * Log all priorities in debug builds, no-op in release builds.
 */
class LogcatInitializer : Initializer<Unit> {
  override fun create(
    context: Context,
  ) {
    AndroidLogcatLogger.installOnDebuggableApp(
      application = context as Application,
      minPriority = LogPriority.VERBOSE,
    )
  }

  override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
