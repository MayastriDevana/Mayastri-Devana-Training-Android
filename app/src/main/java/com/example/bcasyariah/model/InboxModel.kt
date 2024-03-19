package com.example.bcasyariah.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InboxModel (
        val inboxDate: String,
        val inboxMassage: String,
    ): Parcelable