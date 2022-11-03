package com.saadi.mvvmroomdb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadi.mvvmroomdb.model.repositoy.EmployRepository
import com.saadi.mvvmroomdb.model.models.EmployModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployVM @Inject constructor(
    private val employRepository: EmployRepository
) : ViewModel() {

    fun getEmploys(): LiveData<List<EmployModel>> {
        return employRepository.getEmploys()
    }

    fun saveEmploy(employEntity: EmployModel) {
        viewModelScope.launch(Dispatchers.IO) {
            employRepository.saveEmploy(employEntity)
        }
    }

    fun updateEmploy(employEntity: EmployModel) {
        viewModelScope.launch {
            employRepository.updateEmploy(employEntity)
        }
    }

    fun deleteEmploy(employEntity: EmployModel) {
        viewModelScope.launch {
            employRepository.deleteEmploy(employEntity)
        }
    }


}