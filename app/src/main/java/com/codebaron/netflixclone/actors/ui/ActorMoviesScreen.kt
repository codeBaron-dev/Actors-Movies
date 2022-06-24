package com.codebaron.netflixclone.actors.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.codebaron.netflixclone.R
import com.codebaron.netflixclone.actors.model.videos.Resource
import com.codebaron.netflixclone.actors.model.videos.Video
import com.codebaron.netflixclone.actors.model.videos.dummyObjects.DummyVideos.videos
import com.codebaron.netflixclone.actors.viewmodel.ActorsViewModel
import com.codebaron.netflixclone.ui.theme.NetflixCloneTheme
import com.codebaron.netflixclone.utilities.DUMMY_TEXT
import com.codebaron.netflixclone.utilities.EPISODES
import com.codebaron.netflixclone.utilities.PROGRESS_LEVELS
import com.codebaron.netflixclone.utilities.SEASONS

@Composable
fun MovieScreen(
    navController: NavController,
    actorsViewModel: ActorsViewModel
) {
    val actorsIds by actorsViewModel.getAllActorsId().observeAsState(initial = emptyList())
    val actorsMovies by actorsViewModel.getAllActorsVideos().observeAsState()
}

@Composable
fun ActorsResources(
    navController: NavController,
    properties: Resource,
    videos: List<Video>
) {
    Scaffold {
        Box(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.Gray)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
            ) {
                MovieHeaderView(videos)

                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}

@Composable
fun MovieHeaderView(properties: List<Video>) {
    val getRandomVideoObject = properties.random()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .height(490.dp)
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .drawWithCache {
                            val gradient = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                startY = size.height / 30,
                                endY = size.height
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient, blendMode = BlendMode.Multiply)
                            }
                        },
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = getRandomVideoObject.image.url)
                            .apply(block = fun ImageRequest.Builder.() {
                                placeholder(R.drawable.anime)
                                error(R.drawable.anime)
                            }).build()
                    ),
                    contentDescription = DUMMY_TEXT,
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = getRandomVideoObject.primaryTitle.title,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Justify,
                                maxLines = 1,
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.size(7.dp))

                            Text(
                                text = ".",
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Justify,
                                color = Color.Red
                            )

                            Spacer(modifier = Modifier.size(7.dp))

                            Text(
                                text = getRandomVideoObject.primaryTitle.titleType,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Justify,
                                maxLines = 1,
                                color = Color.White
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "",
                                    tint = Color.White
                                )
                                Text(
                                    text = "My List",
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.Light,
                                    textAlign = TextAlign.Justify,
                                    maxLines = 1,
                                    color = Color.White
                                )
                            }
                            Card(
                                modifier = Modifier
                                    .width(110.dp)
                                    .height(60.dp)
                                    .padding(15.dp)
                                    .clickable { }
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "",
                                        tint = Color.Black
                                    )
                                    Text(
                                        text = "Play",
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.Light,
                                        textAlign = TextAlign.Justify,
                                        maxLines = 1,
                                        color = Color.Black
                                    )
                                }
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    imageVector = Icons.Outlined.Info,
                                    contentDescription = "",
                                    tint = Color.White
                                )
                                Text(
                                    text = "Info",
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.Light,
                                    textAlign = TextAlign.Justify,
                                    maxLines = 1,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.size(15.dp))

        MovieList(videos)
    }
}

@Composable
fun MovieList(videos: List<Video>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Continue Watching for codeBaron",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            maxLines = 1,
            color = Color.White
        )
        LazyRow {
            items(videos) { content ->
                Card(modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .clickable {}
                ) {
                    Column {
                        BoxWithConstraints(
                            modifier = Modifier
                                .width(120.dp)
                                .height(200.dp)
                        ) {
                            Box {
                                Image(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .fillMaxWidth()
                                        .drawWithCache {
                                            val gradient = Brush.verticalGradient(
                                                colors = listOf(Color.Transparent, Color.Black),
                                                startY = size.height / 30,
                                                endY = size.height
                                            )
                                            onDrawWithContent {
                                                drawContent()
                                                drawRect(gradient, blendMode = BlendMode.Multiply)
                                            }
                                        },
                                    painter = rememberAsyncImagePainter(
                                        ImageRequest.Builder(LocalContext.current)
                                            .data(data = content.primaryTitle.image)
                                            .apply(block = fun ImageRequest.Builder.() {
                                                placeholder(R.drawable.anime)
                                                error(R.drawable.anime)
                                            }).build()
                                    ),
                                    contentDescription = DUMMY_TEXT,
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.Center),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.PlayCircle,
                                    contentDescription = "",
                                    tint = Color.White,
                                    modifier = Modifier.size(70.dp)
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentAlignment = Alignment.BottomCenter
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "${SEASONS.random()}:${EPISODES.random()}",
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.Light,
                                            textAlign = TextAlign.Justify,
                                            maxLines = 1,
                                            color = Color.White,
                                            modifier = Modifier.padding(3.dp)
                                        )
                                        LinearProgressIndicator(
                                            progress = PROGRESS_LEVELS.random(),
                                            color = Color.Red,
                                            modifier = Modifier.width(120.dp)
                                        )
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp)
                                        .background(colorResource(id = R.color.gray_color))
                                        .clickable { }
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Outlined.Info,
                                            contentDescription = "",
                                            tint = Color.White
                                        )

                                        Spacer(modifier = Modifier.size(45.dp))

                                        Icon(
                                            imageVector = Icons.Outlined.MoreVert,
                                            contentDescription = "",
                                            tint = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesDisplay() {
    NetflixCloneTheme {
        MovieHeaderView(
            properties = videos
        )
    }
}