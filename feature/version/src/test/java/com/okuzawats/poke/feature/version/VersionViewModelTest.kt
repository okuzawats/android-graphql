package com.okuzawats.poke.feature.version

import com.okuzawats.poke.core.logger.Logger
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class VersionViewModelTest {

  private lateinit var sut: VersionViewModel

  private lateinit var versionRepository: VersionRepository
  private lateinit var logger: Logger

  @Before
  fun setup() {
    versionRepository = mockk()
    logger = mockk(relaxUnitFun = true)

    sut = VersionViewModel(
      versionRepository = versionRepository,
      logger = logger,
    )
  }

  @Test
  fun onEntered() = runTest {
    coEvery {
      versionRepository.fetch()
    } returns Result.failure(
      Throwable("failure"),
    )

    sut.onEntered()

    verify {
      logger.v("failure")
    }
  }
}
