package com.okuzawats.poke.api.okhttp

import com.okuzawats.poke.api.okhttp.interceptor.LoggingInterceptorQualifier
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * factory of [OkHttpClient].
 */
internal class OkHttpClientFactory @Inject constructor(
  @LoggingInterceptorQualifier
  private val loggingInterceptor: Interceptor,
) {
  /**
   * returns the instance of [OkHttpClient].
   */
  fun create(): OkHttpClient {
    return OkHttpClient.Builder()
      .connectTimeout(5, TimeUnit.SECONDS)
      .writeTimeout(5, TimeUnit.SECONDS)
      .readTimeout(5, TimeUnit.SECONDS)
      .addInterceptor(loggingInterceptor)
      .build()
  }
}
