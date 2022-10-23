package com.saadi.mvvmroomdb.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saadi.mvvmroomdb.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Database(entities = [EmployEntity::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun employDao(): EmployDao

    companion object {

        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context): RoomDB {
            if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDB::class.java,
                        Constants.DATABASE_NAME
                    ).build()
            }
            return INSTANCE!!
        }
    }

}