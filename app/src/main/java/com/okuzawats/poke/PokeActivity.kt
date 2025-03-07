package com.okuzawats.poke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.okuzawats.feature.main.MainScreen
import com.okuzawats.poke.design.PokeTheme
import com.okuzawats.poke.feature.version.VersionScreen
import com.okuzawats.poke.navigation.PokeNavigationRoute
import com.okuzawats.poke.navigation.PokeNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PokeActivity : ComponentActivity() {

  @Inject
  lateinit var pokeNavigator: PokeNavigator

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      PokeTheme {
        val navController: NavHostController = rememberNavController()
        pokeNavigator.setupNavHostController(navController)

        Scaffold(
          modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
          NavHost(
            navController = navController,
            startDestination = PokeNavigationRoute.Main.name,
            modifier = Modifier.padding(innerPadding),
          ) {
            composable(PokeNavigationRoute.Main.name) {
              MainScreen()
            }
            composable(PokeNavigationRoute.Version.name) {
              VersionScreen()
            }
          }
        }
      }
    }
  }

  override fun onDestroy() {
    pokeNavigator.tearDownNavHostController()
    super.onDestroy()
  }
}
