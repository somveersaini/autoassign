package com.kilvish.autoassign.data.agent

import com.kilvish.autoassign.data.agent.model.AgentResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AgentService {
    @GET("fetchTask/{type}")
    fun getAutoAssignData(@Path("type") request: String): Single<Response<AgentResponse>>
}