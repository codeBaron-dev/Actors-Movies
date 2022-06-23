package com.codebaron.netflixclone.actors.model.videos

data class PrimaryTitle(
    val disambiguation: String,
    val episode: Int,
    val id: String,
    val image: ImageXX,
    val season: Int,
    val title: String,
    val titleType: String,
    val year: Int
)