package com.w1nkkkk.binchecker.data.repository

import com.w1nkkkk.binchecker.data.datasource.remote.BinRemoteDatasource
import com.w1nkkkk.binchecker.data.mapper.BinDtoModelMapper
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.domain.BinRepository
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(
    private val binRemoteDatasource: BinRemoteDatasource
) : BinRepository {
    private val mapper = BinDtoModelMapper()

    override suspend fun getBin(bin: Int): BinModel {
        return mapper.map(binRemoteDatasource.getBin(bin))
    }
}