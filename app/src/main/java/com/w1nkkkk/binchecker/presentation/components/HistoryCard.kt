package com.w1nkkkk.binchecker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.domain.HistoryModel

@Composable
fun HistoryCard(historyModel: HistoryModel) {
    val expanded = remember {
        mutableStateOf(false)
    }

    Card(onClick = { expanded.value = !expanded.value },
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        elevation = CardDefaults.elevatedCardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp).fillMaxWidth()) {
            HistoryCardTop(historyModel, expanded.value)
            if (expanded.value) {
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Column (modifier = Modifier.fillMaxWidth()) {
                    BankInfo(historyModel.binInfo)
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    CountryInfo(historyModel.binInfo)
                }
            }
        }
    }
}

@Composable
@Preview
fun HistoryCardReview() {
    val historyModel = HistoryModel(
        312314,
        binInfo = BinModel(
            scheme = "VISA",
            bankName = "SBER",
            bankUrl = "URL HTTPS SUPER DUPER",
            bankPhone = "+7 495 723 67 67",
            countryName = "RUSSIAN FEDERATION",
            countryLongitude = 60,
            countryLatitude = 100,
        )
    )

    HistoryCard(historyModel)
}