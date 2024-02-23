package com.dwh.kosmos.data.api

import com.dwh.kosmos.data.model.response.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): Response<ApiResponse>

}