package com.okuzawats.poke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.okuzawats.poke.core.logger.Logger
import com.okuzawats.poke.feature.version.VersionRepository
import com.okuzawats.poke.feature.version.VersionScreen
import com.okuzawats.poke.ui.theme.PokeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject
  lateinit var versionRepository: VersionRepository

  @Inject
  lateinit var logger: Logger

  override fun onCreate(
    savedInstanceState: Bundle?,
  ) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      PokeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          VersionScreen(
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }

    lifecycleScope.launch {
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
