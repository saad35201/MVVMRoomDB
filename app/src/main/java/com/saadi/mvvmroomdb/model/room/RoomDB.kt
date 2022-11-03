package com.saadi.mvvmroomdb.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saadi.mvvmroomdb.model.models.EmployModel
import com.saadi.mvvmroomdb.utils.Constants

@Database(entities = [EmployModel::class], version = 1, exportSchema = false)
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