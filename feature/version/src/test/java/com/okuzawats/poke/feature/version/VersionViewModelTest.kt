package com.okuzawats.poke.feature.version

import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class VersionViewModelTest {

  private lateinit var sut: VersionViewModel

  private lateinit var versionRepository: VersionRepository

  @Before
  fun setup() {
    versionRepository = mockk()

    sut = VersionViewModel(
      versionRepository = versionRepository,
      logger = mockk(relaxUnitFun = true),
    )
  }

  @Test
  fun onEntered() {
  }
}
