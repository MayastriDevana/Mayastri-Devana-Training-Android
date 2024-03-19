package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.adapter.ListTransactionAdapter
import com.example.bcasyariah.databinding.ActivityListTransactionBinding
import com.example.bcasyariah.model.TransactionModel

class ListTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListTransactionBinding

    private var transactionAdapter = ListTransactionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RvListTransaction.adapter = transactionAdapter
        transactionAdapter.setData(createDummyListTransaction())

        transactionAdapter.setOnClickTransaction { transaction ->
            navigateToDetailTransaction(transaction)
        }
    }

    private fun navigateToDetailTransaction(data: TransactionModel){
        val intent = Intent(this, DetailTransactionActivity::class.java)
        intent.putExtra(TRANSACTION_KEY, data)
        startActivity(intent)
    }

    private fun createDummyListTransaction(): MutableList<TransactionModel>{
        return mutableListOf(
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QRIS Bank Jago",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 20000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),
            TransactionModel(
                transferType = "Debit",
                transferDestination = "QRIS BCA Syariah",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 500000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),
            TransactionModel(
                transferType = "Debit",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),TransactionModel(
                transferType = "Debit",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),TransactionModel(
                transferType = "Debit",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            ),TransactionModel(
                transferType = "Debit",
                transferDestination = "QRIS Mandiri",
                date = "13/03/2024",
                transferStatus = "Sukses",
                amount = 100000.0
            )
        )

    }
    companion object{
        const val TRANSACTION_KEY = "transaction_key"
    }
}