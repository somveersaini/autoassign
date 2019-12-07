package com.kilvish.autoassign.ui.agent

import com.kilvish.autoassign.data.agent.model.AgentData

sealed class AgentViewState

object InitialState: AgentViewState()

object LoadingState : AgentViewState()

data class ErrorState(val errorMessage: String) : AgentViewState()

data class SuccessState(val agentData: AgentData) : AgentViewState()
