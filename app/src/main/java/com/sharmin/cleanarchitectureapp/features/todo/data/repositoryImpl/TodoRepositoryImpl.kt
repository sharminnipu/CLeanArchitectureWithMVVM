package com.sharmin.cleanarchitectureapp.features.todo.data.repositoryImpl

import com.sharmin.cleanarchitectureapp.core.base.BaseResult
import com.sharmin.cleanarchitectureapp.core.base.Failure
import com.sharmin.cleanarchitectureapp.features.todo.data.local.TodoDao
import com.sharmin.cleanarchitectureapp.features.todo.data.remote.TodoRemoteSource
import com.sharmin.cleanarchitectureapp.features.todo.domain.entity.TodoEntity
import com.sharmin.cleanarchitectureapp.features.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TodoRepositoryImpl constructor(
    private val todoRemoteSource: TodoRemoteSource,
    private val todoDao: TodoDao
) : TodoRepository {

    override suspend fun fetchTodos(): Flow<BaseResult<List<TodoEntity>, Failure>> {
        return flow {
            val localTodos = todoDao.findAll()

            // send the local db value to db
            emit(BaseResult.Success(localTodos))

            // is should fetch?
            if(localTodos.isNullOrEmpty()){
                val result = todoRemoteSource.fetchTodos()
                if(result is BaseResult.Success){
                    saveToLocal(result.data)
                }
                emit(result)
            }
        }
    }


    private fun saveToLocal(todos: List<TodoEntity>){
        todoDao.deleteAll()
        todoDao.insertAll(todos)
    }
}