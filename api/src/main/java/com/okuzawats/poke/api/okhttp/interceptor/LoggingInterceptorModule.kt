package com.okuzawats.poke.api.okhttp.interceptor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class LoggingInterceptorModule {
  @LoggingInterceptorQualifier
  @Provides
  @Singleton
  fun provideLoggingInterceptor(
    factory: LoggingInterceptorFactory,
  ): Interceptor {
    return factory.create()
  }
}
