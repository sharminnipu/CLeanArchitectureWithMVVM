package com.sharmin.cleanarchitectureapp.core.module

import android.content.Context
import androidx.room.Room
import com.sharmin.cleanarchitectureapp.core.AppDatabase.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "mydb").allowMainThreadQueries().build()
    }
}