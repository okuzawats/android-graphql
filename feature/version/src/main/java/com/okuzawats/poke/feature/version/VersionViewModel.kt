package com.okuzawats.poke.feature.version

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okuzawats.poke.core.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for version screen.
 */
@HiltViewModel
class VersionViewModel @Inject constructor(
  private val versionRepository: VersionRepository,
  private val logger: Logger,
) : ViewModel() {
  /**
   * on entered to version screen.
   */
  fun onEntered() {
    viewModelScope.launch {
      versionRepository.fetch()
        .onSuccess {
          logger.v(it.toString())
        }
        .onFailure {
          logger.v(it.message!!)
        }
    }
  }
}
