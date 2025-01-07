package com.w1nkkkk.binchecker.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.w1nkkkk.binchecker.domain.HistoryModel
import com.w1nkkkk.binchecker.domain.HistoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val repository: HistoryRepository
) : ViewModel() {

    val history : MutableStateFlow<List<HistoryModel>> = MutableStateFlow(emptyList())

    init {
        getHistory()
    }

    fun insertBin(bin: HistoryModel) {
        CoroutineScope(Dispatchers.IO).launch {
            val historyList : MutableList<HistoryModel> = history.value.toMutableList()
            historyList.add(0, bin)
            history.emit(historyList)
            repository.insertHistoryItem(bin)
        }

    }

    fun getHistory() {
        CoroutineScope(Dispatchers.IO).launch {
            history.emit(repository.getBins().asReversed())
        }
    }
}