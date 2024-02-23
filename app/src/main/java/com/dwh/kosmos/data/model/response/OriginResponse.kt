package com.dwh.kosmos.data.model.response

import com.google.gson.annotations.SerializedName

data class OriginResponse(
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)
