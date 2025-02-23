package com.okuzawats.poke.feature.version

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun VersionScreen(
  modifier: Modifier = Modifier,
  viewModel: VersionViewModel = hiltViewModel(),
) {
  LaunchedEffect(Unit) {
    viewModel.onEntered()
  }

  Greeting(
    name = "Android",
    modifier = modifier,
  )
}
