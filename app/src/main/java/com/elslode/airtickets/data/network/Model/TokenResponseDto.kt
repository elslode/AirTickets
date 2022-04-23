package com.elslode.airtickets.data.network.Model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TokenResponseDto(
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("token")
    @Expose
    val token: String? = null,
    @SerializedName("result")
    @Expose
    val result: String? = null
)