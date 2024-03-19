package com.example.bcasyariah.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.DialogLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {
    fun showConfirmationDialog(
        title: String,
        icon: Int? = null,
        onConfirm: () -> Unit,
        onCancel: () -> Unit,
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val binding = DialogLayoutBinding.bind(dialogView)

        binding.tvDialogue.text = title

        if (icon != null) {
            binding.ivIconDialog.visibility = View.VISIBLE
            binding.ivIconDialog.setImageResource(icon)
        } else {
            binding.ivIconDialog.visibility = View.GONE
        }
        alertDialog.setView(dialogView)

        binding.buttonYes.setOnClickListener {
            onConfirm.invoke()
            alertDialog.dismiss()
        }
        binding.buttonNo.setOnClickListener {
            onConfirm.invoke()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
}