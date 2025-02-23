package com.okuzawats.poke

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.okuzawats.poke.design.PokeTheme
import javax.inject.Inject

/**
 * common initializer for [ComponentActivity]
 */
class PokeActivityInitializer @Inject constructor() {
  /**
   * initialize [activity]
   *
   * @param activity the instance of [ComponentActivity] to initialize.
   * @param content Composable function of the root content.
   */
  fun initialize(
    activity: ComponentActivity,
    content: @Composable (innerPadding: PaddingValues) -> Unit
  ) {
    activity.enableEdgeToEdge()
    activity.setContent {
      PokeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          content(innerPadding)
        }
      }
    }
  }
}
