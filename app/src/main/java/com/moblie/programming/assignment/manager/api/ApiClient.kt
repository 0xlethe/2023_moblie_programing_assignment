package com.moblie.programming.assignment.manager.api

import com.moblie.programming.assignment.manager.CertificateManager
import com.moblie.programming.assignment.type.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        var client: ApiInterface = Retrofit.Builder()
                .baseUrl(Common.API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiInterface::class.java)
        fun getList(){
            client.getList().enqueue(object : Callback<ApiResult> {
                override fun onResponse(
                    call: Call<ApiResult>,
                    response: Response<ApiResult>
                ) {
                    CertificateManager.data = response.body()?.data?.certification!!.sortedBy { it.id }
                }

                override fun onFailure(call: Call<ApiResult>, t: Throwable) {
                    CertificateManager.data = listOf()
                }
            })
        }
    }
}