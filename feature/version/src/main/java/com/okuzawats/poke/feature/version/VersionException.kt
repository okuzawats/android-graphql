package com.okuzawats.poke.feature.version

/**
 * exception when fetching version.
 *
 * @param reason the reason of the exception.
 * @param message the detail of the exception.
 */
class VersionException(
  reason: Reason,
  message: String,
) : Throwable(message) {
  enum class Reason {
    /**
     * empty response body.
     */
    Empty,

    /**
     * something happened on IO.
     */
    IO,
  }
}
