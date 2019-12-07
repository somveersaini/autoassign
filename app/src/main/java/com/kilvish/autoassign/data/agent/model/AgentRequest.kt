package com.kilvish.autoassign.data.agent.model

import com.google.gson.annotations.SerializedName

data class AgentRequest(
    @SerializedName("type") val type: String
)