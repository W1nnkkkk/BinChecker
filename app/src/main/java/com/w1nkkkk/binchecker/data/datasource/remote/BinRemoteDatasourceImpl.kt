package com.w1nkkkk.binchecker.data.datasource.remote

import com.w1nkkkk.binchecker.data.entity.BinDtoModel
import retrofit2.await

class BinRemoteDatasourceImpl : BinRemoteDatasource {
    private val apiClient = ApiClient("https://lookup.binlist.net/")
    private val apiService = apiClient.retrofit.create(BinListApiService::class.java)

    override suspend fun getBin(bin: Int): BinDtoModel {
        return apiService.getBin(bin).await()
    }
}