package com.kilvish.autoassign.data.agent.model

import android.os.Parcelable
import com.gojek.redcarpet.data.base.RemoteResponse
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class AgentResponse (
    @SerializedName("data") override var data: AgentData
): RemoteResponse<AgentData>

@Parcelize
data class AgentData (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("roles") val roles: ArrayList<String>?
) : Parcelable