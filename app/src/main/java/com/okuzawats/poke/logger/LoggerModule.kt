package com.okuzawats.poke.logger

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerModule {
  @Binds
  abstract fun bindLogger(impl: LoggerImpl): Logger
}
