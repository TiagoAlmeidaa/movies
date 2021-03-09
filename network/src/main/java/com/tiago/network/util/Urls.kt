package com.tiago.network.util

object Urls {

    init {
        System.loadLibrary(Constants.SECRET_FILE)
    }

    external fun apiUrl(): String

    external fun posterUrl(): String
}