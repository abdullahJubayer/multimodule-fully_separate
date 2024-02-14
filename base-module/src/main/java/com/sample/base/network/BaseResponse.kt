package com.sample.base.network


import com.google.gson.annotations.SerializedName




data class BaseResponse<T>(
    @SerializedName("success" ) var success : Boolean = false,
    @SerializedName("code"    ) var code    : Int = 505,
    @SerializedName("data"    ) var data    : T?    = null,
    @SerializedName("message" ) var message : String = ""
)