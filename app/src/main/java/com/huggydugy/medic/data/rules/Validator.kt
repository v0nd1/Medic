package com.huggydugy.medic.data.rules

object Validator {

    fun validateEmail(email:String): ValidationResult {
        return ValidationResult(
            (!email.isNullOrEmpty())
        )
    }

}

data class ValidationResult(
    val status: Boolean = false
)