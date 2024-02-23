package com.dwh.kosmos.domain.model

import com.dwh.kosmos.data.model.response.OriginResponse
import com.google.gson.annotations.SerializedName

data class OriginResModel(
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)

fun OriginResponse.toDomain() = OriginResModel(name, url)