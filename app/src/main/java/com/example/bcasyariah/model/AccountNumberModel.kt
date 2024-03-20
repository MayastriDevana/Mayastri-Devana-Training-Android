package com.example.bcasyariah.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccountNumberModel (
    val savingType: Int,
    val numberRekening: Int,
    val balanceAmount: String,
): Parcelable