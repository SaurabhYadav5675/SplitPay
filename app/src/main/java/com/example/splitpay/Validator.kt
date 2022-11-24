package com.example.splitpay

import com.example.splitpay.model.DailyRecord
import com.example.splitpay.utilities.Utility

object Validator {
    private val emailPattern = Regex("""^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*${'$'}""")

    fun validateInput(data: String): Boolean {
        return (data.isNotEmpty() && data.lowercase() != "null");
    }

    fun validEmail(email: String): Boolean {
        return emailPattern.matches(email)
    }

    fun validDailyRecord(data: DailyRecord): Boolean {
        return listOf<Boolean>(
            Utility.checkEmptyString(data.title),
            Utility.checkEmptyString(data.date)
        ).all { it }
    }
}