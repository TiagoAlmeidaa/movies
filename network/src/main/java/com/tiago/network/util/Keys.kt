package com.tiago.network.util

object Keys {

    init {
        System.loadLibrary(Constants.SECRET_FILE)
    }

    external fun apiKey(): String
}