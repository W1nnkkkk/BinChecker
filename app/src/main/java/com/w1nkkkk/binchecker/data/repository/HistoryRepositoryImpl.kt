package com.w1nkkkk.binchecker.data.repository

import com.w1nkkkk.binchecker.data.datasource.local.HistoryLocalDatasource
import com.w1nkkkk.binchecker.data.mapper.HistoryDboModelMapper
import com.w1nkkkk.binchecker.domain.HistoryModel
import com.w1nkkkk.binchecker.domain.HistoryRepository
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val historyLocalDatasource: HistoryLocalDatasource
) : HistoryRepository {
    private val mapper = HistoryDboModelMapper()

    override suspend fun insertHistoryItem(bin: HistoryModel) {
        historyLocalDatasource.insertHistoryItem(mapper.mapToDboModel(bin))
    }

    override suspend fun getBins(): List<HistoryModel> {
       return historyLocalDatasource.getBins().map { mapper.map(it) }
    }
}