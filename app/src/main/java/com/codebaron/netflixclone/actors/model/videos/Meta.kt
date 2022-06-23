package com.codebaron.netflixclone.actors.model.videos

data class Meta(
    val operation: String,
    val requestId: String,
    val serviceTimeMs: Double
)