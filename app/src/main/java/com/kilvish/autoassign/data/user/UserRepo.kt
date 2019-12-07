package com.kilvish.autoassign.data.user

import com.kilvish.autoassign.data.user.model.UserApplicationRequest
import com.kilvish.autoassign.data.user.model.UserApplicationResponseData
import com.kilvish.autoassign.utils.mapResponse
import io.reactivex.Single

class UserRepo (
    private val userService: UserService
){
    fun submitApplication(
        type: String,
        custTitle: String,
        pannumber: String,
        dob: String,
        aadharNumber: String,
        custName: String
    ): Single<UserApplicationResponseData> {
        return userService
            .submitApplication(UserApplicationRequest(type, custTitle, pannumber, dob, aadharNumber, custName))
            .flatMap { mapResponse(it) }
            .onErrorResumeNext { Single.error(it) }
    }
}