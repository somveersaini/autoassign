package com.kilvish.autoassign.data.agent.model

import com.google.gson.annotations.SerializedName

data class AgentRequest(
    @SerializedName("agent_id") val agent_id: String,
    @SerializedName("doc_type") val doc_type: String
)