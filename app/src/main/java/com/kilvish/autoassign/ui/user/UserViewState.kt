package com.kilvish.autoassign.ui.user

import com.kilvish.autoassign.data.user.model.UserApplicationResponseData

sealed class UserViewState

object InitialState: UserViewState()

object LoadingState : UserViewState()

data class ErrorState(val errorMessage: String) : UserViewState()

data class SuccessState(val userAppResponseData: UserApplicationResponseData) : UserViewState()
