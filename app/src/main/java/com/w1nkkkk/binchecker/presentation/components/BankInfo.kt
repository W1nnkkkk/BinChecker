package com.w1nkkkk.binchecker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.w1nkkkk.binchecker.R
import com.w1nkkkk.binchecker.domain.BinModel

@Composable
fun BankInfo(binInfo : BinModel) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoldBinText(
            context.getString(R.string.bank),
        )
        Spacer(modifier = Modifier.padding(vertical = 2.dp))
        BinText(binInfo.bankName)
        BinText(binInfo.bankUrl)
        BinText(binInfo.bankPhone)
    }
}