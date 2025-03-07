package com.okuzawats.feature.main

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * main screen.
 */
@Composable
fun MainScreen(
  modifier: Modifier = Modifier,
  viewModel: MainViewModel = hiltViewModel(),
) {
  LaunchedEffect(Unit) {
    viewModel.onEntered()
  }

  TextButton(
    modifier = modifier,
    onClick = {
      viewModel.onTapMeTapped()
    },
    content = {
      Text("tap me!")
    }
  )
}
