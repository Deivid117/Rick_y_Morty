package com.dwh.kosmos.domain.model

import com.dwh.kosmos.data.model.response.CharactersResponse
import com.google.gson.annotations.SerializedName

data class CharactersResModel(
    @SerializedName("id"       ) var id       : Int?              = null,
    @SerializedName("name"     ) var name     : String?           = null,
    @SerializedName("status"   ) var status   : String?           = null,
    @SerializedName("species"  ) var species  : String?           = null,
    @SerializedName("type"     ) var type     : String?           = null,
    @SerializedName("gender"   ) var gender   : String?           = null,
    @SerializedName("origin"   ) var origin   : OriginResModel?           = OriginResModel(),
    @SerializedName("location" ) var location : LocationResModel?         = LocationResModel(),
    @SerializedName("image"    ) var image    : String?           = null,
    @SerializedName("episode"  ) var episode  : ArrayList<String> = arrayListOf(),
    @SerializedName("url"      ) var url      : String?           = null,
    @SerializedName("created"  ) var created  : String?           = null
)

fun CharactersResponse.toDomain() = CharactersResModel(id, name, status, species, type, gender, origin?.toDomain(), location?.toDomain(), image, episode, url, created)