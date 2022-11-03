package com.saadi.mvvmroomdb.model.repositoy

import androidx.lifecycle.LiveData
import com.saadi.mvvmroomdb.model.models.EmployModel
import com.saadi.mvvmroomdb.model.room.RoomDB
import javax.inject.Inject

class EmployRepository @Inject constructor(
    private val roomDB: RoomDB
    ) {

    fun getEmploys() : LiveData<List<EmployModel>>{
        return roomDB.employDao().getEmploys()
    }

    suspend fun saveEmploy(employEntity: EmployModel){
        return roomDB.employDao().saveEmploy(employEntity)
    }

    suspend fun updateEmploy(employEntity: EmployModel){
        return roomDB.employDao().updateEmploy(employEntity)
    }

    suspend fun deleteEmploy(employEntity: EmployModel){
        return roomDB.employDao().deleteEmploy(employEntity)
    }

}