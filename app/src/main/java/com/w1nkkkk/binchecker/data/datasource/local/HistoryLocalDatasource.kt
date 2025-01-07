package com.w1nkkkk.binchecker.data.datasource.local

import com.w1nkkkk.binchecker.data.entity.HistoryDboModel

interface HistoryLocalDatasource {
    suspend fun insertHistoryItem(bin : HistoryDboModel)

    suspend fun getBins() : List<HistoryDboModel>
}