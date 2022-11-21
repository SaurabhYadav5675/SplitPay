package com.example.splitpay

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun checkValidInput() {
        val amount = 10;
        val des = "yurt"

        val result = Validator.validateInput(amount, des)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun checkValidEmail() {
        val email = "saurabh@gmail.com"
        val result = Validator.validEmail(email)
        assertThat(result).isEqualTo(true)
    }
}