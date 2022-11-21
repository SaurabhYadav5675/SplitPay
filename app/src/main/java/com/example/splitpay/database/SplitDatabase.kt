package com.example.splitpay.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.splitpay.model.DailyRecord

@Database(entities = [DailyRecord::class], version = 1)
abstract class SplitDatabase : RoomDatabase() {

    abstract fun dailyRecordDAO(): DailyRecordDAO

    companion object {
        @Volatile
        private var Instance: SplitDatabase? = null

        fun getDatabase(context: Context): SplitDatabase {
            if (Instance == null) {
                synchronized(this)
                {
                    Instance = Room.databaseBuilder(
                        context.applicationContext,
                        SplitDatabase::class.java,
                        "splitDB"
                    ).build()
                }
            }
            return Instance!!
        }
    }
}