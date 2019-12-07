package com.kilvish.autoassign.data.user

import com.kilvish.autoassign.data.user.model.UserApplicationRequest
import com.kilvish.autoassign.data.user.model.UserApplicationResponseData
import com.kilvish.autoassign.utils.mapResponse
import io.reactivex.Single

class UserRepo (
    private val userService: UserService
){
    fun submitApplication(
        id: String,
        doc_type: String
    ): Single<UserApplicationResponseData> {
        return userService
            .submitApplication(UserApplicationRequest(id, doc_type))
            .flatMap { mapResponse(it) }
            .onErrorResumeNext { Single.error(it) }
    }
}