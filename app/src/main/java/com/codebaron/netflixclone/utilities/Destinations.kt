package com.codebaron.netflixclone.utilities

enum class Destinations {
    SPLASH_SCREEN,
    MAIN_SCREEN,
    LOGIN_SCREEN,
    ACTORS_HOME_SCREEN
}

enum class RequestHeaderKeys(val type: String, val key: String) {
    HEADER_1("X-RapidAPI-Key", "dbf0c980c8mshda35039ec1bb1eep14807cjsn194318adcc63"),
    HEADER_2("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
}