package com.saadi.mvvmroomdb.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employ")
data class EmployEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val e_id : String,
    val e_name : String,
    val e_number : String,
    val e_mail : String,
    val e_department : String,
    val e_detail : String)