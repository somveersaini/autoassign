package com.kilvish.autoassign.data.agent

import com.kilvish.autoassign.data.agent.model.AgentRequest
import com.kilvish.autoassign.data.agent.model.AgentResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AgentService {
    @POST("autoassign")
    fun getAutoAssignData(@Body request: AgentRequest): Single<Response<AgentResponse>>
}