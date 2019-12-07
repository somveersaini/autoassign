package com.kilvish.autoassign.data.user.model

import com.google.gson.annotations.SerializedName

data class UserApplicationRequest(
    @SerializedName("type")         val type: String,
    @SerializedName("custTitle")    val custTitle: String,
    @SerializedName("pannumber")    val pannumber: String,
    @SerializedName("dob")          val dob: String,
    @SerializedName("aadharNumber") val aadharNumber: String,
    @SerializedName("custName") val custName: String
)