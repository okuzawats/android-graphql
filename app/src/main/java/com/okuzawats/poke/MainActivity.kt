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
import com.apollographql.apollo.ApolloClient
import com.okuzawats.poke.ui.theme.PokeTheme
import kotlinx.coroutines.launch
import logcat.logcat

class MainActivity : ComponentActivity() {
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
      val apolloClient = ApolloClient.Builder()
        .serverUrl("https://beta.pokeapi.co/graphql/v1beta")
        .build()

      val response = apolloClient
        .query(VersionNameQuery())
        .execute()

      logcat {
        "${response.data}"
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
