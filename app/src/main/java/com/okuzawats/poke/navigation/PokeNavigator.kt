package com.okuzawats.poke.navigation

import androidx.navigation.NavHostController
import com.okuzawats.feature.main.MainNavigator
import com.okuzawats.poke.core.logger.Logger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokeNavigator @Inject constructor(
  private val logger: Logger,
) : MainNavigator {
  private var navHostController: NavHostController? = null

  fun setupNavHostController(
    navHostController: NavHostController
  ) {
    this.navHostController = navHostController
  }

  fun tearDownNavHostController() {
    this.navHostController = null
  }

  override fun navigateToNextPage() {
    logger.v("navigate to next page.")
    checkNotNull(navHostController).navigate(PokeNavigationRoute.Version.name)
  }
}
