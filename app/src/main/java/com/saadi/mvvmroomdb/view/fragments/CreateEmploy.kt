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
import com.saadi.mvvmroomdb.model.models.EmployModel
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
    private val mArgs: CreateEmployArgs? by navArgs()


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
            setData(it.employArg)
        }

        //btn save click listener
        mBinding.btnSave.setOnClickListener {
            saveEmploy()
        }

    }

    private fun setData(employArg: EmployModel?) {
        mBinding.etEmployId.setText(employArg?.e_id)
        mBinding.etEmployName.setText(employArg?.e_name)
        mBinding.etEmployNumber.setText(employArg?.e_number)
        mBinding.etEmployEmail.setText(employArg?.e_mail)
        mBinding.etEmployDepartment.setText(employArg?.e_department)
        mBinding.etEmployDetail.setText(employArg?.e_detail)
    }

    private fun saveEmploy() {
        val id = mBinding.etEmployId.text.toString()
        val name = mBinding.etEmployName.text.toString()
        val number = mBinding.etEmployNumber.text.toString()
        val email = mBinding.etEmployEmail.text.toString()
        val department = mBinding.etEmployDepartment.text.toString()
        val detail = mBinding.etEmployDetail.text.toString()

        mArgs?.let {
            //employ object
            val updateEmploy = it.employArg?.id?.let { it1 -> EmployModel(it1, id, name, number, email, department, detail) }
            //updating employ
            it.employArg?.let {
                if (updateEmploy != null) {
                    mEmployeeVM.updateEmploy(updateEmploy)
                }
            }
        } ?:run {
            //employ object
            val newEmploy = EmployModel(0, id, name, number, email, department, detail)
            //saving new employ
            mEmployeeVM.saveEmploy(newEmploy)
        }
        findNavController().navigateUp()

    }

}