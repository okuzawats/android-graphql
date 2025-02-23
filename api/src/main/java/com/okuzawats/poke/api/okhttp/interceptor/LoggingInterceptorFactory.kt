package com.okuzawats.poke.api.okhttp.interceptor

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

/**
 * factory of [Interceptor] that logs request and response.
 */
class LoggingInterceptorFactory @Inject constructor() {
  /**
   * returns the instance of [Interceptor].
   */
  fun create(): Interceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    // log request and response header and body
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return httpLoggingInterceptor
  }
}
