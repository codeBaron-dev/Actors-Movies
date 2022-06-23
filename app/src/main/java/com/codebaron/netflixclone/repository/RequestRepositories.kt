package com.codebaron.netflixclone.repository

import com.codebaron.netflixclone.actors.model.id.ActorsIds
import com.codebaron.netflixclone.actors.model.videos.Resource

interface RequestRepositories {
    suspend fun getActorsIds(month: String, day: String): List<ActorsIds>?
    suspend fun getActorVideos(nconst: String, region: String): Resource?
}