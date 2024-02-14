package com.sample.example_module.network

import com.sample.base.network.BaseResponse
import com.sample.example_module.demo.model.DemoModel
import retrofit2.http.GET

interface ApiService {

    @GET("end_point")
    suspend fun getDemoList() : BaseResponse<List<DemoModel>>
}