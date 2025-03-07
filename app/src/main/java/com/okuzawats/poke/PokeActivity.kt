package com.okuzawats.poke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.okuzawats.feature.main.MainScreen
import com.okuzawats.poke.design.PokeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      PokeTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
//          VersionScreen(
//            modifier = Modifier.padding(innerPadding),
//          )
          MainScreen(
            modifier = Modifier.padding(innerPadding),
          )
        }
      }
    }
  }
}
