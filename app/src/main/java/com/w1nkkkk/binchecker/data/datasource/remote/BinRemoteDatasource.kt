package com.w1nkkkk.binchecker.data.datasource.remote

import com.w1nkkkk.binchecker.data.entity.BinDtoModel

interface BinRemoteDatasource {
    suspend fun getBin(bin : Int) : BinDtoModel
}