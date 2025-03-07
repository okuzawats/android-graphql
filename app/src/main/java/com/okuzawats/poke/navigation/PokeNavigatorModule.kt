package com.okuzawats.poke.navigation

import com.okuzawats.feature.main.MainNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PokeNavigatorModule {
  @Binds
  abstract fun bindPokeNavigator(impl: PokeNavigator): MainNavigator
}
