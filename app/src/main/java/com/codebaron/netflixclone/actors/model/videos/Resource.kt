package com.codebaron.netflixclone.actors.model.videos

data class Resource(
    val type: String,
    val id: String,
    val image: Image,
    val legacyNameText: String,
    val name: String,
    val size: Int,
    val videoCounts: List<VideoCount>,
    val videos: List<Video>
)