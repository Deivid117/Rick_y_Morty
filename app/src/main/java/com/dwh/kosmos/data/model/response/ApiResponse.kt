package com.dwh.kosmos.data.model.response

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("info"    ) var info    : InfoResponse?              = InfoResponse(),
    @SerializedName("results" ) var results : ArrayList<CharactersResponse> = arrayListOf()
)
