package com.okuzawats.poke.feature.version

import com.apollographql.apollo.ApolloClient
import com.okuzawats.poke.api.VersionNameQuery
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class VersionRepositoryTest {

  private lateinit var sut: VersionRepository

  private lateinit var apolloClient: ApolloClient

  @Before
  fun setup() {
    apolloClient = mockk()

    sut = VersionRepository(
      apolloClient = apolloClient,
    )
  }

  @Test
  fun fetch() = runTest {
    coEvery {
      apolloClient
        .query(VersionNameQuery())
        .execute()
    } throws Throwable("failed")

    val actual: Result<List<Version>> = sut.fetch()

    assert(actual.isFailure)
  }
}
