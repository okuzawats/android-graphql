package com.okuzawats.poke.feature.version

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * version screen.
 */
@Composable
fun VersionScreen(
  modifier: Modifier = Modifier,
  viewModel: VersionViewModel = hiltViewModel(),
) {
  LaunchedEffect(Unit) {
    viewModel.onEntered()
  }

  Text(
    text = "Hello World!",
    modifier = modifier,
  )
}
