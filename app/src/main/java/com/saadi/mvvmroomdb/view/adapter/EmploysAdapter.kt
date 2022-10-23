package com.saadi.mvvmroomdb.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saadi.mvvmroomdb.databinding.RvEmployItemBinding
import com.saadi.mvvmroomdb.model.room.EmployEntity

class EmploysAdapter(private val mList: List<EmployEntity>) :
    RecyclerView.Adapter<EmploysAdapter.EmployViewHolder>() {

    //click listeners
    var onItemClick : ((EmployEntity) -> Unit)? = null
    var onItemLongClick : ((EmployEntity) -> Unit)? = null

    class EmployViewHolder(private val binding: RvEmployItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EmployEntity) {
            binding.tvEId.text = item.e_id
            binding.tvEmployName.text = item.e_name
            binding.tvEmployNumber.text = item.e_number
            binding.tvEmployMail.text = item.e_mail
            binding.tvEmployDepartment.text = item.e_department
            binding.tvEmployDepartment.text = item.e_department
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployViewHolder {
        val binding =
            RvEmployItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployViewHolder, position: Int) {
        val item = mList[position]
        holder.bind(item)

        //click listeners
        holder.itemView.setOnClickListener { onItemClick?.invoke(item) }
        holder.itemView.setOnLongClickListener {
            onItemLongClick?.invoke(item)
            return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}