package com.example.splitpay

object Validator {
    private val emailPattern = Regex("""^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*${'$'}""")

    fun validateInput(amount: Int, description: String): Boolean {
        return (amount != 0 && description.isNotEmpty());
    }

    fun validEmail(email: String): Boolean {
        var status = false;
        status = emailPattern.matches(email)
        return status
    }
}