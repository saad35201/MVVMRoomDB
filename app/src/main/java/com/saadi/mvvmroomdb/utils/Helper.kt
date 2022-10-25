package com.saadi.mvvmroomdb.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.saadi.mvvmroomdb.databinding.DeleteEmployDialogBinding

class Helper {

    companion object {

        fun Context.showDeleteDialog(
            message: String,
            updateButton: (() -> Unit)? = null,
            deleteButton: (() -> Unit)? = null
        ) {
            val binding = DeleteEmployDialogBinding.inflate(LayoutInflater.from(this))
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(true)
            dialog.setContentView(binding.root)
            binding.tvMessage.text = message
            binding.btnUpdate.setOnClickListener {
                updateButton?.invoke()
                dialog.dismiss()
            }
            binding.btnDelete.setOnClickListener {
                deleteButton?.invoke()
                dialog.dismiss()
            }
            dialog.show()
        }

    }

}