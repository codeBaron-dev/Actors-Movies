package com.codebaron.netflixclone.actors.model.videos

data class Video(
    val audioLanguage: String,
    val contentType: String,
    val description: String,
    val durationInSeconds: Int,
    val id: String,
    val image: ImageX,
    val primaryTitle: PrimaryTitle,
    val title: String
)