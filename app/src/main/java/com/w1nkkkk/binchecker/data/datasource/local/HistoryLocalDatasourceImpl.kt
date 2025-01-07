package com.w1nkkkk.binchecker.data.datasource.local

import android.content.Context
import com.w1nkkkk.binchecker.data.entity.HistoryDboModel
import javax.inject.Inject

class HistoryLocalDatasourceImpl @Inject constructor(
    private val context : Context
) : HistoryLocalDatasource {
    private val database = HistoryDatabase.getInstance(context)

    override suspend fun insertHistoryItem(bin : HistoryDboModel) {
        database.getHistoryDao().insertHistoryItem(bin)
    }

    override suspend fun getBins(): List<HistoryDboModel> {
        return database.getHistoryDao().getBins()
    }
}