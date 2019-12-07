package com.kilvish.autoassign.utils

import com.gojek.redcarpet.data.base.RemoteResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.annotations.CheckReturnValue
import io.reactivex.annotations.SchedulerSupport
import retrofit2.HttpException
import retrofit2.Response


inline fun <reified T> mapResponse(it: Response<out RemoteResponse<T>>): Single<T>? {
    val body = it.body()
    return if (it.isSuccessful && body != null) {
        Single.just(body.data)
    } else {
        Single.error(HttpException(it))
    }
}

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any, U : Any> Observable<T>.notOfType(clazz: Class<U>): Observable<T> {
    checkNotNull(clazz) { "clazz is null" }
    return filter { !clazz.isInstance(it) }
}