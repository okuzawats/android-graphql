package com.okuzawats.poke.logger

import logcat.logcat
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {
  override fun v(message: String) {
    logcat { message }
  }
}
