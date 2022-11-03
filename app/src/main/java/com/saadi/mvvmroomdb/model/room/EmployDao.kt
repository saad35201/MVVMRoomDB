package com.saadi.mvvmroomdb.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.saadi.mvvmroomdb.model.models.EmployModel

@Dao
interface EmployDao {

    @Query("SELECT * FROM employ ORDER BY id DESC")
    fun getEmploys() : LiveData<List<EmployModel>>

    @Insert
    suspend fun saveEmploy(employ : EmployModel)

    @Update
    suspend fun updateEmploy(employ: EmployModel)

    @Delete
    suspend fun deleteEmploy(employEntity: EmployModel)

}