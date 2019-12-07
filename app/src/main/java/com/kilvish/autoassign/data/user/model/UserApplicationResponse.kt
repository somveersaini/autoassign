package com.kilvish.autoassign.data.user.model

import android.os.Parcelable
import com.gojek.redcarpet.data.base.RemoteResponse
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class UserApplicationResponse (
    @SerializedName("data") override var data: UserApplicationResponseData
): RemoteResponse<UserApplicationResponseData>

@Parcelize
data class UserApplicationResponseData (
    @SerializedName("result") val result: String
) : Parcelable