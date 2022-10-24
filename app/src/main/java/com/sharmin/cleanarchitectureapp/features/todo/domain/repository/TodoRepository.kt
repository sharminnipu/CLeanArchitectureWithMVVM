package com.sharmin.cleanarchitectureapp.features.todo.domain.repository

import com.sharmin.cleanarchitectureapp.core.base.BaseResult
import com.sharmin.cleanarchitectureapp.core.base.Failure
import com.sharmin.cleanarchitectureapp.features.todo.domain.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun fetchTodos() : Flow<BaseResult<List<TodoEntity>, Failure>>
}