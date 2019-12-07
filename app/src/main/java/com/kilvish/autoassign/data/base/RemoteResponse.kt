package com.gojek.redcarpet.data.base

//specifies remote response as response and its data model

interface RemoteResponse<T>{
    val data: T
}