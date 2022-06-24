package com.codebaron.netflixclone.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.codebaron.netflixclone.R
import com.codebaron.netflixclone.ui.theme.NetflixCloneTheme
import com.codebaron.netflixclone.utilities.DUMMY_TEXT
import com.codebaron.netflixclone.utilities.Destinations.LOGIN_SCREEN
import com.codebaron.netflixclone.utilities.NETFLIX_LOGO
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigationController: NavHostController) {
    val scale = remember { Animatable(0f) }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            Spacer(modifier = Modifier.size(350.dp))

            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(150.dp)
                    .width(150.dp)
                    .aspectRatio(16f / 9f),
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = NETFLIX_LOGO).apply(block = fun ImageRequest.Builder.() {
                        placeholder(R.drawable.netflix)
                        error(R.drawable.netflix)
                    }).build()
                ),
                contentDescription = DUMMY_TEXT,
                contentScale = ContentScale.FillWidth
            )
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7F,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4F).getInterpolation(it)
                    })
            )
            delay(3000L)
            navigationController.navigate(LOGIN_SCREEN.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashDisplay() {
    NetflixCloneTheme {
        SplashScreen(navigationController = rememberNavController())
    }
}
