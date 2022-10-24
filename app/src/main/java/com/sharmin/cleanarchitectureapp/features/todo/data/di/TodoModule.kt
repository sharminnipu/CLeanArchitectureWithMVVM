package com.sharmin.cleanarchitectureapp.features.todo.data.di

import com.sharmin.cleanarchitectureapp.core.AppDatabase.AppDatabase
import com.sharmin.cleanarchitectureapp.features.todo.data.local.TodoDao
import com.sharmin.cleanarchitectureapp.features.todo.data.remote.TodoRemoteSource
import com.sharmin.cleanarchitectureapp.features.todo.data.remote.api.TodoApi
import com.sharmin.cleanarchitectureapp.features.todo.data.repositoryImpl.TodoRepositoryImpl
import com.sharmin.cleanarchitectureapp.features.todo.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Provides
    @Singleton
    fun provideTodoRemoteApi(retrofit: Retrofit) : TodoApi {
        return retrofit.create(TodoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTodoRemoteSource(todoApi: TodoApi) : TodoRemoteSource {
        return TodoRemoteSource(todoApi)
    }

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: AppDatabase) : TodoDao {
        return appDatabase.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(todoRemoteSource: TodoRemoteSource, todoDao: TodoDao) : TodoRepository {
        return TodoRepositoryImpl(todoRemoteSource, todoDao)
    }
}