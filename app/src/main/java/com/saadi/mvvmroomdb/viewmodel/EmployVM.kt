package com.saadi.mvvmroomdb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadi.mvvmroomdb.model.repositoy.EmployRepository
import com.saadi.mvvmroomdb.model.room.EmployEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployVM @Inject constructor(
    private val employRepository: EmployRepository
) : ViewModel() {

    fun getEmploys(): LiveData<List<EmployEntity>> {
        return employRepository.getEmploys()
    }

    fun saveEmploy(employEntity: EmployEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            employRepository.saveEmploy(employEntity)
        }
    }

    fun updateEmploy(employEntity: EmployEntity) {
        viewModelScope.launch {
            employRepository.updateEmploy(employEntity)
        }
    }

    fun deleteEmploy(employEntity: EmployEntity) {
        viewModelScope.launch {
            employRepository.deleteEmploy(employEntity)
        }
    }


}