package com.sharmin.cleanarchitectureapp.core.resource

sealed class Resource<T, U>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null): Resource<T, Any?>(data)
    class Success<T>(data: T?): Resource<T, Any?>(data)
    class Error<T>(message: String, data: T? = null): Resource<T, Any?>(data, message)
}