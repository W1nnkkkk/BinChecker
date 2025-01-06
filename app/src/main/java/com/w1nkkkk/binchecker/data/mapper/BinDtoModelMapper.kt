package com.w1nkkkk.binchecker.data.mapper

import com.w1nkkkk.binchecker.data.entity.BinDtoModel
import com.w1nkkkk.binchecker.domain.BinModel

class BinDtoModelMapper {
    fun map(binModel : BinDtoModel) : BinModel {
        return BinModel(
            scheme = binModel.scheme ?: "Scheme not found",
            bankName = binModel.bank.name ?: "Bank name not found",
            bankUrl = binModel.bank.url ?: "Bank url not found",
            bankPhone = binModel.bank.phone ?: "Bank phone not found",
            countryName = binModel.country.name ?: "Country not found",
            countryLongitude = binModel.country.longitude ?: 0,
            countryLatitude = binModel.country.latitude ?: 0,
        )
    }
}