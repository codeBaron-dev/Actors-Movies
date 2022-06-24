package com.codebaron.netflixclone.actors.model.videos.dummyObjects

import com.codebaron.netflixclone.actors.model.videos.Resource
import com.codebaron.netflixclone.actors.model.videos.dummyObjects.DummyImage.image
import com.codebaron.netflixclone.actors.model.videos.dummyObjects.DummyVideoCount.counts
import com.codebaron.netflixclone.actors.model.videos.dummyObjects.DummyVideos.videos

object DummyResource {
    val resource = Resource(
        "imdb.api.name.v2.videos",
        "/name/nm0566052/",
        image,
        "McClurg, Edie",
        "Edie McClurg",
        26,
        counts,
        videos
    )
}