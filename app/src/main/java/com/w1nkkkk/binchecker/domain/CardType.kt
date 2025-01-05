package com.w1nkkkk.binchecker.domain

import android.content.Context
import com.w1nkkkk.binchecker.R

enum class CardType(val nameRes : Int) {
    credit(R.string.credit),
    debit(R.string.debit);

    fun getName(context: Context) : String = context.getString(nameRes)
}