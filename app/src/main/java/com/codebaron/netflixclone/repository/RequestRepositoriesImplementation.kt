package com.codebaron.netflixclone.repository

import com.codebaron.netflixclone.actors.model.id.ActorsIds
import com.codebaron.netflixclone.actors.model.videos.Resource
import com.codebaron.netflixclone.provider.EndPointsProvider
import com.codebaron.netflixclone.utilities.getHeaderMap
import javax.inject.Inject

class RequestRepositoriesImplementation @Inject constructor(private val provider: EndPointsProvider) :
    RequestRepositories {

    private var actorsIds: List<ActorsIds>? = emptyList()
    private var actorVideos: Resource? = null

    override suspend fun getActorsIds(month: String, day: String): List<ActorsIds>? {
        val requestResponse = provider.getActorsIds(getHeaderMap(), month, day)
        if (requestResponse.isSuccessful) {
            actorsIds = requestResponse.body() ?: emptyList()
        }
        return actorsIds
    }

    override suspend fun getActorVideos(nconst: String, region: String): Resource? {
        val requestResponse = provider.getActorMovies(getHeaderMap(), nconst, region)
        if (requestResponse.isSuccessful) {
            actorVideos = requestResponse.body()
        }
        return actorVideos
    }

}