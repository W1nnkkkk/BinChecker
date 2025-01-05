package com.w1nkkkk.binchecker.data.mapper

import com.w1nkkkk.binchecker.data.entity.BinDtoModel
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.domain.CardType

class BinDtoModelMapper {
    fun map(binModel : BinDtoModel) : BinModel {
        return BinModel(
            scheme = binModel.scheme,
            bankCity = binModel.bank.city,
            bankName = binModel.bank.name,
            bankUrl = binModel.bank.city,
            bankPhone = binModel.bank.phone,
            countryName = binModel.country.name,
            countryLongitude = binModel.country.longitude,
            countryLatitude = binModel.country.latitude,
            type = CardType.valueOf(binModel.type)
        )
    }
}