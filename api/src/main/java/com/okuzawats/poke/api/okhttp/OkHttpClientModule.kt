package com.okuzawats.poke.api.okhttp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class OkHttpClientModule {
  @Provides
  @Singleton
  fun provideOkHttpClient(
    factory: OkHttpClientFactory,
  ): OkHttpClient {
    return factory.create()
  }
}
