package com.example.splitpay.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.splitpay.model.DailyRecord
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplitDatabaseTest : TestCase() {
    private lateinit var database: SplitDatabase
    private lateinit var dailyDao: DailyRecordDAO

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, SplitDatabase::class.java).build()
        dailyDao = database.dailyRecordDAO()
    }

    @After
    fun closeDB() {
        database.close()
    }

    @Test
    fun checkDailyOperation() = runBlocking {
        val dailyData =
            DailyRecord(1, "Snacks ", "unit testing for daily record", 1, 100, "null1", "", "")

        dailyDao.insertDailyRecord(dailyData)
        val result = dailyDao.getAllDailyRecord()
        assertThat(result.contains(dailyData)).isTrue()
    }
}