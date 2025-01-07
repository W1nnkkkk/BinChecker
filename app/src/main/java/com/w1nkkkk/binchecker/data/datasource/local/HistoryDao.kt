package com.w1nkkkk.binchecker.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.w1nkkkk.binchecker.data.entity.HistoryDboModel

@Dao
interface HistoryDao {
    @Insert
    fun insertHistoryItem(bin : HistoryDboModel)

    @Query("SELECT * FROM bins")
    fun getBins() : List<HistoryDboModel>
}