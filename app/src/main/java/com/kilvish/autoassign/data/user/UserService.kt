package com.kilvish.autoassign.data.user

import com.kilvish.autoassign.data.user.model.UserApplicationRequest
import com.kilvish.autoassign.data.user.model.UserApplicationResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService{
    @POST("submit")
    fun submitApplication(@Body request: UserApplicationRequest): Single<Response<UserApplicationResponse>>

}