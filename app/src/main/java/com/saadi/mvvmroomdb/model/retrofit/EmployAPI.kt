package com.saadi.mvvmroomdb.model.retrofit

import com.saadi.mvvmroomdb.model.models.EmployModel
import retrofit2.Response
import retrofit2.http.GET

interface EmployAPI {

    @GET("")
    suspend fun getEmploy() : Response<EmployModel>

}