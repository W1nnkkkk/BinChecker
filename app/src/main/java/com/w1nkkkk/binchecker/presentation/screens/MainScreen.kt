package com.w1nkkkk.binchecker.presentation.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.presentation.components.BinInfo
import com.w1nkkkk.binchecker.presentation.components.CheckBinBox
import com.w1nkkkk.binchecker.presentation.viewmodels.BinViewModel

@Composable
fun MainScreen(binModel: BinModel, binViewModel: BinViewModel) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            CheckBinBox(binViewModel)
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            if (binModel.countryLatitude != -1) {
                BinInfo(binModel)
            }
        }
    }
}