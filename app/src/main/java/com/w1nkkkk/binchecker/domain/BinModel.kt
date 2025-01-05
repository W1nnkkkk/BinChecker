package com.w1nkkkk.binchecker.domain

data class BinModel (
    val scheme : String,
    val bankName : String,
    val bankUrl : String,
    val bankPhone : String,
    val bankCity: String,
    val countryName : String,
    val countryLatitude : Int,
    val countryLongitude : Int,
    val type : CardType
) {
    constructor() : this (
        scheme = "",
        bankName = "",
        bankUrl = "",
        bankPhone = "",
        bankCity = "",
        countryName = "",
        countryLatitude = -1,
        countryLongitude = -1,
        type = CardType.credit
    )
}