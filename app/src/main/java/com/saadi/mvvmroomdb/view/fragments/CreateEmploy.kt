package com.saadi.mvvmroomdb.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.saadi.mvvmroomdb.databinding.FragmentCreateEmployBinding
import com.saadi.mvvmroomdb.model.room.EmployEntity
import com.saadi.mvvmroomdb.viewmodel.EmployVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateEmploy : Fragment() {

    companion object {
        //log
        private const val TAG = "CreateEmploy"
    }

    //binding
    private lateinit var mBinding: FragmentCreateEmployBinding

    //viewModel
    private val mEmployeeVM: EmployVM by viewModels()

    //argument
    private val mArgs :CreateEmployArgs? by navArgs()

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

        //setting data in views
        mArgs?.let {
            setData()
        }

        //btn save click listener
        mBinding.btnSave.setOnClickListener {
            saveEmploy()
        }

    }

    private fun setData() {
        mBinding.etEmployId.setText(mArgs?.employArg?.e_id)
        mBinding.etEmployName.setText(mArgs?.employArg?.e_name)
        mBinding.etEmployNumber.setText(mArgs?.employArg?.e_number)
        mBinding.etEmployEmail.setText(mArgs?.employArg?.e_mail)
        mBinding.etEmployDepartment.setText(mArgs?.employArg?.e_department)
        mBinding.etEmployDetail.setText(mArgs?.employArg?.e_detail)
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

        //updating employ
        mArgs?.let {
            it.employArg?.let { it1 -> mEmployeeVM.updateEmploy(it1) }
        }
        //saving new employ
        mEmployeeVM.saveEmploy(employEntity)
        findNavController().navigateUp()

    }

}