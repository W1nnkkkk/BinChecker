package com.w1nkkkk.binchecker.data.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class BinDtoModel(
    @SerializedName("scheme") val scheme : String?,
    @SerializedName("country") val country : CountryDtoModel,
    @SerializedName("bank") val bank : BankDtoModel
) {
    @Serializable
    data class CountryDtoModel(
        @SerializedName("name") val name : String?,
        @SerializedName("latitude") val latitude : Int?,
        @SerializedName("longitude") val longitude : Int?
    )

    @Serializable
    data class BankDtoModel(
        @SerializedName("name") val name : String?,
        @SerializedName("url") val url : String?,
        @SerializedName("phone") val phone : String?,
    )
}