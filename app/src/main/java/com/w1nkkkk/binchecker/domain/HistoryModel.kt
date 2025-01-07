package com.w1nkkkk.binchecker.domain

data class HistoryModel(
    val binNum : Int,
    val binInfo : BinModel
) {
    constructor() : this(
        binNum = -1,
        binInfo = BinModel()
    )
}
