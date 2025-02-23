package com.okuzawats.poke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.okuzawats.poke.feature.version.VersionScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PokeActivity : ComponentActivity() {

  @Inject
  lateinit var initializer: PokeActivityInitializer

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initializer.initialize(
      activity = this,
      content = { innerPadding ->
        VersionScreen(
          modifier = Modifier.padding(innerPadding)
        )
      },
    )
  }
}
