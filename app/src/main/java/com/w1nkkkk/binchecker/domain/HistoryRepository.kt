package com.w1nkkkk.binchecker.domain

interface HistoryRepository {
    suspend fun insertHistoryItem(bin : HistoryModel)
    suspend fun getBins() : List<HistoryModel>
}