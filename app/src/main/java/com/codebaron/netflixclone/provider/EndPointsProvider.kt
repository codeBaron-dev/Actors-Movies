package com.codebaron.netflixclone.provider

import com.codebaron.netflixclone.actors.model.id.ActorsIds
import com.codebaron.netflixclone.actors.model.videos.Resource
import com.codebaron.netflixclone.utilities.ACTORS_IDS
import com.codebaron.netflixclone.utilities.ACTOR_VIDEOS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface EndPointsProvider {

    @GET(ACTORS_IDS)
    suspend fun getActorsIds(
        @HeaderMap headers: Map<String, String>,
        @Query("month", encoded = true) month: String,
        @Query("day", encoded = true) day: String
    ): Response<List<ActorsIds>>

    @GET(ACTOR_VIDEOS)
    fun getActorMovies(
        @HeaderMap headers: Map<String, String>,
        @Query("nconst", encoded = true) nconst: String,
        @Query("region", encoded = true) region: String
    ): Response<Resource>
}