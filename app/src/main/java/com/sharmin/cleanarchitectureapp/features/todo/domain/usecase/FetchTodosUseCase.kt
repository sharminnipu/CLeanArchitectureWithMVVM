package com.sharmin.cleanarchitectureapp.features.todo.domain.usecase

import com.sharmin.cleanarchitectureapp.core.base.BaseResult
import com.sharmin.cleanarchitectureapp.core.base.Failure
import com.sharmin.cleanarchitectureapp.features.todo.domain.entity.TodoEntity
import com.sharmin.cleanarchitectureapp.features.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchTodosUseCase @Inject constructor(private val todoRepository: TodoRepository) {
    suspend fun invoke() : Flow<BaseResult<List<TodoEntity>, Failure>> {
        return todoRepository.fetchTodos()
    }
}