package com.example.splitpay

import com.example.splitpay.model.DailyRecord
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun checkValidInput() {
        val data = "testing data"
        val result = Validator.validateInput(data)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun checkValidEmail() {
        val email = "saurabh@gmail.com"
        val result = Validator.validEmail(email)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun checkValidDailyRecord() {
        val dailyData =
            DailyRecord(1, "Snacks ", "unit testing for daily record", 1, 100, "null1", "", "")
        val result = Validator.validDailyRecord(dailyData)
        assertThat(result).isEqualTo(true)
    }
}