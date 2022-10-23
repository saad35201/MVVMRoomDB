package com.saadi.mvvmroomdb.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.saadi.mvvmroomdb.R
import com.saadi.mvvmroomdb.databinding.FragmentCreateEmployBinding
import com.saadi.mvvmroomdb.model.room.EmployEntity
import com.saadi.mvvmroomdb.viewmodel.EmployVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateEmploy : Fragment() {

    //binding
    private lateinit var mBinding: FragmentCreateEmployBinding

    //viewModel
    private val mEmployeeVM : EmployVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentCreateEmployBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //btn save click listener
        mBinding.btnSave.setOnClickListener {

            saveEmploy()

        }

    }

    private fun saveEmploy() {
        val id = mBinding.etEmployId.text.toString()
        val name = mBinding.etEmployName.text.toString()
        val number = mBinding.etEmployNumber.text.toString()
        val email = mBinding.etEmployEmail.text.toString()
        val department = mBinding.etEmployDepartment.text.toString()
        val detail = mBinding.etEmployDetail.text.toString()

        //employ object
        val employEntity = EmployEntity(
            0,
            id,
            name,
            number,
            email,
            department,
            detail
        )
        mEmployeeVM.saveEmploy(employEntity)
        findNavController().navigateUp()

    }

}