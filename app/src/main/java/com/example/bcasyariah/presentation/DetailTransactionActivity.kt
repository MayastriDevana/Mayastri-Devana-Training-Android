package com.example.bcasyariah.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.databinding.ActivityDetailTransactionBinding
import com.example.bcasyariah.model.TransactionModel
import com.example.bcasyariah.presentation.ListTransactionActivity.Companion.TRANSACTION_KEY

class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = intent.getParcelableExtra<TransactionModel>(TRANSACTION_KEY)
        binding.tvTransferDate.text = transaction?.date
        binding.tvTransferType.text = transaction?.transferType
        binding.tvTransferAmount.text = transaction?.amount.toString()
        binding.tvTransferDestination.text = transaction?.transferDestination
        binding.tvTransferStatus.text = transaction?.transferStatus
    }
}