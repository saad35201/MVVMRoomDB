package com.saadi.mvvmroomdb.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.saadi.mvvmroomdb.R
import com.saadi.mvvmroomdb.databinding.FragmentAllEmploysBinding
import com.saadi.mvvmroomdb.model.room.EmployEntity
import com.saadi.mvvmroomdb.view.adapter.EmploysAdapter
import com.saadi.mvvmroomdb.viewmodel.EmployVM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AllEmploys : Fragment() {


    //binding var
    private lateinit var mBinding: FragmentAllEmploysBinding

    //viewModel
    private val mEmployeeVM : EmployVM by viewModels()

    //adapter and layout manager var
    private lateinit var mAdapter: EmploysAdapter
    private lateinit var mManager: LinearLayoutManager




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentAllEmploysBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setting employ rv
        mEmployeeVM.getEmploys().observe(requireActivity()) { list ->
            mAdapter = EmploysAdapter(list)
            mManager = LinearLayoutManager(context)
            mBinding.rvEmploys.adapter = mAdapter
            mBinding.rvEmploys.layoutManager = mManager

            //employ item click listener
            mAdapter.onItemLongClick = {
                mEmployeeVM.deleteEmploy(it)
            }
        }

        //btn add click listener
        mBinding.btnAdd.setOnClickListener {

            findNavController().navigate(R.id.action_allEmploys_to_createEmploy)

        }


    }


}
