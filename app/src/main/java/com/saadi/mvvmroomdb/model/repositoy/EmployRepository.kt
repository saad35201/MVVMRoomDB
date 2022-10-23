package com.saadi.mvvmroomdb.model.repositoy

import androidx.lifecycle.LiveData
import com.saadi.mvvmroomdb.model.room.EmployDao
import com.saadi.mvvmroomdb.model.room.EmployEntity
import com.saadi.mvvmroomdb.model.room.RoomDB
import javax.inject.Inject

class EmployRepository @Inject constructor(
    private val roomDB: RoomDB
    ) {

    fun getEmploys() : LiveData<List<EmployEntity>>{
        return roomDB.employDao().getEmploys()
    }

    suspend fun saveEmploy(employEntity: EmployEntity){
        return roomDB.employDao().saveEmploy(employEntity)
    }

    suspend fun updateEmploy(employEntity: EmployEntity){
        return roomDB.employDao().updateEmploy(employEntity)
    }

    suspend fun deleteEmploy(employEntity: EmployEntity){
        return roomDB.employDao().deleteEmploy(employEntity)
    }

}