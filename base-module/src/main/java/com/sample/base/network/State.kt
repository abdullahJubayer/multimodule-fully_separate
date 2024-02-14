package com.sample.base.network

sealed class State<T>(
    val data: T? = null,
    val errorCode: Int = -1,
    val errorMessage: String = ""
) {
    class Success<T>(data: T) : State<T>(data)
    class Loading<T>(data: T? = null) : State<T>(data)
    class DataErrorMessage<T>(error: String,errorCode:Int=0) : State<T>(null, errorCode,error)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is DataErrorMessage -> "Error[exception=$errorMessage]"
            is Loading<T> -> "Loading"
        }
    }
}