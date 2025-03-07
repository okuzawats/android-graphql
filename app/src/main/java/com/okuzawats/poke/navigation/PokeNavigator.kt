package com.okuzawats.poke.navigation

import com.okuzawats.feature.main.MainNavigator
import com.okuzawats.poke.core.logger.Logger
import javax.inject.Inject

class PokeNavigator @Inject constructor(
  private val logger: Logger,
) : MainNavigator {
  override fun navigateToNextPage() {
    logger.v("navigate to next page.")
  }
}
