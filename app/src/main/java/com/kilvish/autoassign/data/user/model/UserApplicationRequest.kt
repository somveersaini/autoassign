package com.kilvish.autoassign.data.user.model

import com.google.gson.annotations.SerializedName

data class UserApplicationRequest(
    @SerializedName("agent_id") val agent_id: String,
    @SerializedName("doc_type") val doc_type: String
)