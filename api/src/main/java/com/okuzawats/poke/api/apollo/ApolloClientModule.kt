package com.okuzawats.poke.api.apollo

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class ApolloClientModule {
  @Provides
  @Singleton
  fun provideApolloClient(
    factory: ApolloClientFactory,
  ): ApolloClient {
    return factory.create()
  }
}
