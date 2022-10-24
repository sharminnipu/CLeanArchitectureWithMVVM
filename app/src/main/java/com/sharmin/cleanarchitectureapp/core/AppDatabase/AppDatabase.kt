package com.sharmin.cleanarchitectureapp.core.AppDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sharmin.cleanarchitectureapp.features.todo.data.local.TodoDao
import com.sharmin.cleanarchitectureapp.features.todo.domain.entity.TodoEntity

@Database(
    entities = [
        TodoEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun todoDao() : TodoDao
}