package com.example.splitpay.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_record")
data class DailyRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val type: Int,
    val amount: Int,
    val date: String,
    val time: String,
    val createdAt: String
)
