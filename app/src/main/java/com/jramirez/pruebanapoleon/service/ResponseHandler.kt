package com.jramirez.pruebanapoleon.service

class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return Resource.error(e.message?: "", null)
    }

    fun <T : Any> handleException(e: String): Resource<T> {
        return Resource.error(e, null)
    }
}