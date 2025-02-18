package com.okuzawats.poke.apollo

import com.apollographql.apollo.ApolloClient
import javax.inject.Inject

private const val END_POINT_URL = "https://beta.pokeapi.co/graphql/v1beta"

/**
 * factory of [ApolloClient].
 */
class ApolloClientFactory @Inject constructor() {
  /**
   * returns the instance of [ApolloClient].
   */
  fun create(): ApolloClient {
    val apolloClient = ApolloClient.Builder()
      .serverUrl(END_POINT_URL)
      .build()
    return apolloClient
  }
}
