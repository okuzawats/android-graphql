package com.okuzawats.poke.okhttp

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * factory of [OkHttpClient].
 */
class OkHttpClientFactory @Inject constructor() {
  /**
   * returns the instance of [OkHttpClient].
   */
  fun create(): OkHttpClient {
    val client = OkHttpClient.Builder()
      .connectTimeout(5, TimeUnit.SECONDS)
      .writeTimeout(5, TimeUnit.SECONDS)
      .readTimeout(5, TimeUnit.SECONDS)
      .build()

    return client
  }
}
