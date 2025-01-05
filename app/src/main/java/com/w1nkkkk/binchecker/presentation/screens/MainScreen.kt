package com.w1nkkkk.binchecker.presentation.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.presentation.components.CheckBinBox
import com.w1nkkkk.binchecker.presentation.viewmodels.BinViewModel

@Composable
fun MainScreen(binModel: BinModel, binViewModel: BinViewModel, context : Context) {
    Column {
        CheckBinBox(binViewModel, context)


    }
}