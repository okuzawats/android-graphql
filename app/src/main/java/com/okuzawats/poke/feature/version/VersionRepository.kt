package com.okuzawats.poke.feature.version

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloResponse
import com.okuzawats.poke.api.VersionNameQuery
import dagger.Reusable
import javax.inject.Inject

/**
 * repository for [Version].
 */
@Reusable
class VersionRepository @Inject constructor(
  private val apolloClient: ApolloClient,
) {
  /**
   * fetch list of [Version]s.
   *
   * @return return the result of fetching list of [Version]s as [Result].
   */
  suspend fun fetch(): Result<List<Version>> {
    val res: ApolloResponse<VersionNameQuery.Data> = try {
      apolloClient
        .query(VersionNameQuery())
        .execute()
    } catch (e: Throwable) {
      return Result.failure(
        VersionException(
          reason = VersionException.Reason.IO,
          message = "oops, something happened on IO!",
        )
      )
    }

    if (res.data == null) {
      return Result.failure(
        VersionException(
          reason = VersionException.Reason.Empty,
          message = "response data is null.",
        )
      )
    }

    val data: VersionNameQuery.Data = checkNotNull(res.data)
    val versions = data.pokemon_v2_versionname.map {
      Version(
        id = it.id,
        name = it.name,
      )
    }
    return Result.success(versions)
  }
}
