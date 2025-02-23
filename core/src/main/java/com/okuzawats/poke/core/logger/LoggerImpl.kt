package com.okuzawats.poke.core.logger

import android.app.Application
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import logcat.AndroidLogcatLogger
import logcat.LogPriority
import logcat.logcat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class LoggerImpl @Inject constructor(
  @ApplicationContext
  context: Context,
) : Logger {
  init {
    // we do not need test, so can initialize logger here:)
    AndroidLogcatLogger.installOnDebuggableApp(
      application = context as Application,
      minPriority = LogPriority.VERBOSE,
    )
  }

  override fun v(message: String) {
    logcat { message }
  }
}
