package com.okuzawats.poke.apollo

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.network.okHttpClient
import okhttp3.OkHttpClient
import javax.inject.Inject

private const val END_POINT_URL = "https://beta.pokeapi.co/graphql/v1beta"

/**
 * factory of [ApolloClient].
 */
class ApolloClientFactory @Inject constructor(
  private val okHttpClient: OkHttpClient,
) {
  /**
   * returns the instance of [ApolloClient].
   */
  fun create(): ApolloClient {
    return ApolloClient.Builder()
      .serverUrl(END_POINT_URL)
      .okHttpClient(okHttpClient)
      .build()
  }
}
