package com.w1nkkkk.binchecker.data.mapper

import com.w1nkkkk.binchecker.data.entity.HistoryDboModel
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.domain.HistoryModel

class HistoryDboModelMapper {
    fun map(historyModel : HistoryDboModel) : HistoryModel {
        return HistoryModel(
            binNum = historyModel.bin,
            binInfo = BinModel(
                scheme = historyModel.scheme,
                bankName = historyModel.bankName,
                bankUrl = historyModel.bankUrl,
                bankPhone = historyModel.bankPhone,
                countryName = historyModel.countryName,
                countryLongitude = historyModel.countryLongitude,
                countryLatitude = historyModel.countryLatitude,
            )
        )
    }

    fun mapToDboModel(historyModel: HistoryModel) : HistoryDboModel {
        return HistoryDboModel(
            bin = historyModel.binNum,
            scheme = historyModel.binInfo.scheme,
            bankName = historyModel.binInfo.bankName,
            bankUrl = historyModel.binInfo.bankUrl,
            bankPhone = historyModel.binInfo.bankPhone,
            countryName = historyModel.binInfo.countryName,
            countryLongitude = historyModel.binInfo.countryLongitude,
            countryLatitude = historyModel.binInfo.countryLatitude,
        )
    }
}