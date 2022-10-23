package com.saadi.mvvmroomdb.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saadi.mvvmroomdb.model.room.EmployDao
import com.saadi.mvvmroomdb.model.room.RoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    @Singleton
    @Provides
    fun provideRoomDB(@ApplicationContext appContext: Context): RoomDB {
        return RoomDB.getInstance(appContext)
    }

    @Singleton
    @Provides
    fun provideEmployDao(roomDB: RoomDB) : EmployDao{
        return roomDB.employDao()
    }

}