package com.okuzawats.poke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.okuzawats.feature.main.MainScreen
import com.okuzawats.poke.design.PokeTheme
import com.okuzawats.poke.feature.version.VersionScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      PokeTheme {
        val navController = rememberNavController()

        Scaffold(
          modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
          NavHost(
            navController = navController,
            startDestination = NavigationRoute.Main.name,
            modifier = Modifier.padding(innerPadding),
          ) {
            composable(NavigationRoute.Main.name) {
              MainScreen()
            }
            composable(NavigationRoute.Version.name) {
              VersionScreen()
            }
          }
        }
      }
    }
  }
}
