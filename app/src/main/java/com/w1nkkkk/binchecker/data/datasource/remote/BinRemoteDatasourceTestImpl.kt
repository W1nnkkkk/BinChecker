package com.w1nkkkk.binchecker.data.datasource.remote

import com.w1nkkkk.binchecker.data.entity.BinDtoModel
import retrofit2.await

class BinRemoteDatasourceTestImpl : BinRemoteDatasource {

    override suspend fun getBin(bin: Int): BinDtoModel {
        return BinDtoModel(
            scheme = "VISA",
            country = BinDtoModel.CountryDtoModel(
                name = "RUSSIA",
                latitude = 44,
                longitude = 24
            ),
            bank = BinDtoModel.BankDtoModel(
                name = "SBER",
                url = "https://online.sberbank.ru/",
                phone = "84952457979"
            )
        )
    }
}