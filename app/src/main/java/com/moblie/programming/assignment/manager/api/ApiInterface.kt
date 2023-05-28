package com.moblie.programming.assignment.manager.api

import com.moblie.programming.assignment.type.Common.Companion.API_LIST
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(API_LIST)
    fun getList(): Call<ApiResult>
}