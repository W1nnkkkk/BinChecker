package com.w1nkkkk.binchecker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bins")
data class HistoryDboModel(
    @PrimaryKey(true) val id : Int = 0,
    val bin : Int,
    val scheme : String,
    val bankName : String,
    val bankUrl : String,
    val bankPhone : String,
    val countryName : String,
    val countryLatitude : Int,
    val countryLongitude : Int,
)
