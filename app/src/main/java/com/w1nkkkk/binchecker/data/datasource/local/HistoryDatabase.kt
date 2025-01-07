package com.w1nkkkk.binchecker.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.w1nkkkk.binchecker.data.entity.HistoryDboModel

@Database(entities = [HistoryDboModel::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() {

    abstract fun getHistoryDao() : HistoryDao

    companion object {
        private var INSTANCE : HistoryDatabase? = null
        private val DB_NAME : String = "history_db"

        fun getInstance(context: Context) : HistoryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    HistoryDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}