package com.w1nkkkk.binchecker.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun BinInfo(binModel: BinModel) {
    val context = LocalContext.current
    val horizontalSpace = 15.dp

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Absolute.Center) {
            BoldBinText(context.getString(R.string.card_scheme))
            BinText(": ${binModel.scheme}")
        }

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            BoldBinText(
                context.getString(R.string.bank),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            BinText(binModel.bankName, modifier = Modifier.fillMaxWidth())
            BinText(binModel.bankUrl, modifier = Modifier.fillMaxWidth())
            BinText(binModel.bankPhone, modifier = Modifier.fillMaxWidth())
        }

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BoldBinText(context.getString(R.string.country))
            BinText(binModel.countryName)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Absolute.Center) {
                BoldBinText(context.getString(R.string.latitude))
                BinText(": ${binModel.countryLatitude}")
                Spacer(modifier = Modifier.padding(horizontal = horizontalSpace))
                BoldBinText(context.getString(R.string.longitude))
                BinText(": ${binModel.countryLongitude}")
            }

        }
    }
}