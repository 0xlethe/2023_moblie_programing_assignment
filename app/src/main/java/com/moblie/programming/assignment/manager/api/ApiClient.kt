package com.moblie.programming.assignment.manager.api

import android.util.Log
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
            val result = client.getList().enqueue(object : Callback<ApiResult> {
                override fun onResponse(
                    call: Call<ApiResult>,
                    response: Response<ApiResult>
                ) {
                    Log.d("TEST", "성공 : ${response.body()?.data?.certification?.get(0)?.name} ${
                        response.body()?.data?.certification?.get(
                            0
                        )?.amount?.size
                    }${
                        response.body()?.data?.certification?.get(
                            0
                        )?.amount?.get(0)?.key
                    }\"")


                    CertificateManager.data = response.body()?.data?.certification!!
                }

                override fun onFailure(call: Call<ApiResult>, t: Throwable) {
                    Log.d("TEST", "실패 : $t")
                }
            })
        }
    }
}