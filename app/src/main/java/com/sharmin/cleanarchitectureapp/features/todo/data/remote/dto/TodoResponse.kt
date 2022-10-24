package com.sharmin.cleanarchitectureapp.features.todo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TodoResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("completed") var isCompleted: Boolean
)