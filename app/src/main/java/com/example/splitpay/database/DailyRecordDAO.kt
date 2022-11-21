package com.example.splitpay.database

import androidx.room.*
import com.example.splitpay.model.DailyRecord

@Dao
interface DailyRecordDAO {
    @Insert
    suspend fun insertDailyRecord(records: DailyRecord)

    @Update
    suspend fun updateDailyRecord(record: DailyRecord)

    @Delete
    suspend fun deleteDailyRecord(record: DailyRecord)

    @Query("SELECT * FROM daily_record")
    fun getAllDailyRecord(): List<DailyRecord>

    @Query("SELECT * FROM daily_record WHERE id like :recordId")
    fun getDailyRecord(recordId: String): List<DailyRecord>

    @Query("SELECT * FROM daily_record ORDER BY id DESC LIMIT 1")
    fun getLatestDailyRecord(): List<DailyRecord>
}