package com.jramirez.pruebanapoleon.repository

import com.jramirez.pruebanapoleon.service.JSONPlaceholderAPI
import com.jramirez.pruebanapoleon.service.Resource
import com.jramirez.pruebanapoleon.service.ResponseHandler
import com.jramirez.pruebanapoleon.service.RetrofitClient

interface BaseRepository {

    val client: JSONPlaceholderAPI
        get() = RetrofitClient.client

    private val responseHandler: ResponseHandler
        get() = ResponseHandler()

    suspend fun <T : Any> handleAPICall(
        clientCall: suspend () -> T
    ): Resource<T> {
        return try {
            responseHandler.handleSuccess(clientCall.invoke())
        }catch (e : Exception){
            responseHandler.handleException(e)
        }
    }
}