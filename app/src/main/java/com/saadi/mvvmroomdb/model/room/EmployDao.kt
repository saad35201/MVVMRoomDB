package com.saadi.mvvmroomdb.model.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployDao {

    @Query("SELECT * FROM employ ORDER BY id DESC")
    fun getEmploys() : LiveData<List<EmployEntity>>

    @Insert
    suspend fun saveEmploy(employ : EmployEntity)

    @Update
    suspend fun updateEmploy(employ: EmployEntity)

    @Delete
    suspend fun deleteEmploy(employEntity: EmployEntity)

}