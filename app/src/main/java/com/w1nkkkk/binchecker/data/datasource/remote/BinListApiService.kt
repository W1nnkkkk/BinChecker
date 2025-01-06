package com.w1nkkkk.binchecker.data.datasource.remote

import com.w1nkkkk.binchecker.data.entity.BinDtoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface BinListApiService {
    @GET("{bin}")
    fun getBin(
        @Path("bin") bin : Int,
    ) : Call<BinDtoModel>
}