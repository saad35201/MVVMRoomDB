package com.saadi.mvvmroomdb.model.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "employ")
data class EmployModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val e_id : String,
    val e_name : String,
    val e_number : String,
    val e_mail : String,
    val e_department : String,
    val e_detail : String) : Parcelable