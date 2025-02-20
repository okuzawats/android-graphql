package com.okuzawats.poke.okhttp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoggingInterceptorModule {
  @LoggingInterceptorQualifier
  @Provides
  @Singleton
  fun provideLoggingInterceptor(
    factory: LoggingInterceptorFactory,
  ): Interceptor {
    return factory.create()
  }
}
