package com.w1nkkkk.binchecker.domain

data class BinModel (
    val scheme : String,
    val bankName : String,
    val bankUrl : String,
    val bankPhone : String,
    val countryName : String,
    val countryLatitude : Int,
    val countryLongitude : Int,
) {
    constructor() : this (
        scheme = "",
        bankName = "",
        bankUrl = "",
        bankPhone = "",
        countryName = "",
        countryLatitude = -1,
        countryLongitude = -1,
    )
}