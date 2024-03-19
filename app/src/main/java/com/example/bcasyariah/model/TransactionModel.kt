package com.example.bcasyariah.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionModel(
    val transferType: String,
    val transferDestination: String,
    val date: String,
    val transferStatus: String,
    val amount: Double
) :Parcelable