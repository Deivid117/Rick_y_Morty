package com.dwh.kosmos.domain.model

import com.dwh.kosmos.data.model.response.LocationResponse
import com.google.gson.annotations.SerializedName

data class LocationResModel(
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)

fun LocationResponse.toDomain() = LocationResModel(name, url)