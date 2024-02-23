package com.dwh.kosmos.domain.model

import com.dwh.kosmos.data.model.response.ApiResponse
import com.dwh.kosmos.data.model.response.InfoResponse
import com.dwh.kosmos.data.model.response.CharactersResponse
import com.google.gson.annotations.SerializedName

data class ApiResModel(
    @SerializedName("info"    ) var info    : InfoResModel?              = InfoResModel(),
    @SerializedName("results" ) var results : ArrayList<CharactersResModel> = arrayListOf()
)

fun ApiResponse.toDomain() = ApiResModel(info?.toDomain(), results.map { it.toDomain() } as ArrayList<CharactersResModel>)