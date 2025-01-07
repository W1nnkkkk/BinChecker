package com.w1nkkkk.binchecker.presentation.components

import androidx.compose.foundation.clickable
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
fun CountryInfo(binInfo : BinModel) {
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoldBinText(context.getString(R.string.country))
        BinText(binInfo.countryName)
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row(Modifier.fillMaxWidth().clickable {
            openLocation(context, binInfo.countryLatitude, binInfo.countryLongitude, binInfo.countryName)
        }, horizontalArrangement = Arrangement.Center) {
            BoldBinText(context.getString(R.string.latitude))
            BinText(": ${binInfo.countryLatitude}")
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            BoldBinText(context.getString(R.string.longitude))
            BinText(": ${binInfo.countryLongitude}")
        }
    }
}