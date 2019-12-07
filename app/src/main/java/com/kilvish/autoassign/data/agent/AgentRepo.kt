package com.kilvish.autoassign.data.agent

import com.kilvish.autoassign.data.agent.model.AgentData
import com.kilvish.autoassign.data.agent.model.AgentRequest
import com.kilvish.autoassign.utils.mapResponse
import io.reactivex.Single

class AgentRepo(val agentService: AgentService) {

    fun getAutoAssignData(
        id: String,
        doc_type: String
    ): Single<AgentData> {
        return agentService
            .getAutoAssignData(AgentRequest(id, doc_type))
            .flatMap { mapResponse(it) }
            .onErrorResumeNext { Single.error(it) }
    }
}