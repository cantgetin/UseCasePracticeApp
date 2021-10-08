package com.example.diworkshop.models.entities.state

sealed class LoadingResult<out T> {
    object Processed : LoadingResult<Nothing>()
    class Success<T>(val data: T) : LoadingResult<T>()
    class Error(val exception: Throwable) : LoadingResult<Nothing>()
}