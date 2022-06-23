package com.codebaron.netflixclone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.codebaron.netflixclone.R
import com.codebaron.netflixclone.ui.theme.NetflixCloneTheme
import com.codebaron.netflixclone.utilities.*

@Composable
fun LoginScreen(navigationController: NavHostController) {
    InputFields()
}

@Composable
fun InputFields() {
    val context = LocalContext.current
    val email = remember { mutableStateOf(TextFieldValue()) }
    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val passwordVisibility = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        // Netflix logo
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(150.dp)
                .width(150.dp)
                .aspectRatio(16f / 9f),
            painter = rememberImagePainter(
                data = NETFLIX_LOGO,
                builder = {
                    error(R.drawable.netflix)
                },
            ),
            contentDescription = DUMMY_TEXT,
            contentScale = ContentScale.FillWidth
        )

        // Welcome text with styling
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Red)) {
                append(
                    WELCOME.take(3)
                )
            }

            withStyle(style = SpanStyle()) {
                append(
                    WELCOME.takeLast(4)
                )
            }
        }, fontSize = 30.sp)

        Spacer(modifier = Modifier.size(16.dp))

        // Email field
        OutlinedTextField(
            value = email.value,
            onValueChange = {
                if (emailErrorState.value) emailErrorState.value = false
                email.value = it
            },
            isError = emailErrorState.value,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = ENTER_EMAIL_ADDRESS)
            })
        if (emailErrorState.value) Text(text = REQUIRED_FIELD, color = Color.Red)

        Spacer(modifier = Modifier.size(16.dp))

        // Password field
        OutlinedTextField(
            value = password.value, onValueChange = {
                if (passwordErrorState.value) passwordErrorState.value = false
                password.value = it
            },
            isError = passwordErrorState.value,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = ENTER_PASSWORD)
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                    Icon(
                        imageVector = if (passwordVisibility.value) Icons.Filled.Lock else Icons.Filled.Info,
                        contentDescription = DUMMY_TEXT
                    )
                }
            },
            visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
        )
        if (passwordErrorState.value) Text(text = REQUIRED_FIELD, color = Color.Red)

        Spacer(modifier = Modifier.size(16.dp))

        // Button
        Button(
            onClick = {
                when {
                    email.value.text.isEmpty() -> {
                        emailErrorState.value = true
                    }
                    password.value.text.isEmpty() -> {
                        passwordErrorState.value = true
                    }
                    else -> {
                        emailErrorState.value = false
                        passwordErrorState.value = false
                        //TODO: make network request
                    }
                }
            },
            content = {
                Text(text = LOGIN, fontSize = 17.sp)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginDisplay() {
    NetflixCloneTheme {
        LoginScreen(navigationController = rememberNavController())
    }
}