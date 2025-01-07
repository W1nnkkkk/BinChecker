package com.w1nkkkk.binchecker.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.w1nkkkk.binchecker.presentation.components.HistoryCard
import com.w1nkkkk.binchecker.presentation.viewmodels.HistoryViewModel

@Composable
fun HistoryScreen(historyViewModel: HistoryViewModel) {
    val history = historyViewModel.history.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(history.value) {
            HistoryCard(it)
        }
    }
}

