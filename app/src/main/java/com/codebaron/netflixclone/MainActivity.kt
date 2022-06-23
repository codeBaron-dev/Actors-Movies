package com.codebaron.netflixclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.codebaron.netflixclone.screens.ScreenNavigation
import com.codebaron.netflixclone.ui.theme.NetflixCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixCloneTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ScreenNavigation()
                }
            }
        }
    }
}