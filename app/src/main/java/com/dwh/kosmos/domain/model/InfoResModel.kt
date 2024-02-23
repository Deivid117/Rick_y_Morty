package com.dwh.kosmos.domain.model

import com.dwh.kosmos.data.model.response.InfoResponse
import com.google.gson.annotations.SerializedName

data class InfoResModel(
    @SerializedName("count" ) var count : Int?    = null,
    @SerializedName("pages" ) var pages : Int?    = null,
    @SerializedName("next"  ) var next  : String? = null,
    @SerializedName("prev"  ) var prev  : String? = null
)

fun InfoResponse.toDomain() = InfoResModel(count, pages, next, prev)