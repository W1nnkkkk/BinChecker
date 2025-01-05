package com.w1nkkkk.binchecker.domain

interface BinRepository {
    suspend fun getBin(bin : Int) : BinModel
}