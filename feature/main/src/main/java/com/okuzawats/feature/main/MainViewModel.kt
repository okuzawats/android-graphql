package com.okuzawats.feature.main

import androidx.lifecycle.ViewModel
import com.okuzawats.poke.core.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for main screen.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
  private val navigator: MainNavigator,
  private val logger: Logger,
) : ViewModel() {
  /**
   * on entered to main screen.
   */
  fun onEntered() {
    logger.v("onEntered")
  }

  /**
   * on tapped tap me button.
   */
  fun onTapMeTapped() {
    logger.v("onTapMeTapped")
    navigator.navigateToNextPage()
  }
}
