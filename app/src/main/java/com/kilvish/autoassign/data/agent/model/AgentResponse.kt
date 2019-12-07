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
    @SerializedName("id") val aid: String,
    @SerializedName("type") val atype: String,
    @SerializedName("params") val aparams: Map<String, String>
) : Parcelable