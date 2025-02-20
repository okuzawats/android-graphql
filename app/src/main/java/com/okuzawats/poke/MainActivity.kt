package com.okuzawats.poke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.okuzawats.poke.domain.version.VersionRepository
import com.okuzawats.poke.logger.Logger
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
          Greeting(
            name = "Android", modifier = Modifier.padding(innerPadding)
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

@Composable
fun Greeting(
  name: String,
  modifier: Modifier = Modifier,
) {
  Text(
    text = "Hello $name!", modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  PokeTheme {
    Greeting("Android")
  }
}
