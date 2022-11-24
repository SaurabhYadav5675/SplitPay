package com.example.splitpay.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.splitpay.database.SplitDatabase
import com.example.splitpay.model.DailyRecord

class DailyRecordVM(app: Application) : AndroidViewModel(app) {
    var dailyRecord = MutableLiveData<List<DailyRecord>>()
    val records: LiveData<List<DailyRecord>> get() = dailyRecord

    fun getRecords() {
        val recordDao = SplitDatabase.getDatabase(getApplication()).dailyRecordDAO()
        val result = recordDao.getAllDailyRecord()
        dailyRecord.postValue(result)
    }

    suspend fun insertRecord(record: DailyRecord) {
        val recordDao = SplitDatabase.getDatabase(getApplication()).dailyRecordDAO()
        recordDao.insertDailyRecord(record)
        getRecords()
    }
}