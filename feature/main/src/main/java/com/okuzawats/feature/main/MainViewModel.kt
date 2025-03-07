package com.okuzawats.feature.main

import androidx.lifecycle.ViewModel
import com.okuzawats.poke.core.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val logger: Logger,
) : ViewModel() {
  fun onEntered() {
    logger.v("onEntered")
  }
}
